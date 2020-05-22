public void addTableItems(ArrayList<invoiceOBJ> invoiceDataBase) {
    // System.out.println(Arrays.toString(invoiceDataBase.toArray()) + " table");
    //add invoices list to observable list. (GUI format)
    ObservableList<invoiceOBJ> custList = FXCollections.observableArrayList(invoiceDataBase);
    //Put list to filtered List
    FilteredList<invoiceOBJ> flInvoiceOBJS = new FilteredList(custList, p -> true);

    //add search to filter list values.
    getSearchField().textProperty().addListener(((observable, oldValue, newValue) -> {
        switch (choice.getValue().toString()) {
            case "FirstName":
                flInvoiceOBJS.setPredicate(p -> p.getCustomer().getFirstName().getValue().toLowerCase().contains(newValue.toLowerCase()));
                break;
            case "LastName":
                flInvoiceOBJS.setPredicate(p -> p.getCustomer().getLastName().getValue().toLowerCase().contains(newValue.toLowerCase()));
                break;
            case "Date":

                flInvoiceOBJS.setPredicate(p -> p.getGraphicalData("dateOfInvoice").getValue().toLowerCase().contains(newValue.toLowerCase()));
                break;
            case "Manufacturer":
                flInvoiceOBJS.setPredicate(p -> p.getGraphicalData("manufacturer").getValue().toLowerCase().contains(newValue.toLowerCase()));
                break;
            case "ID":
                flInvoiceOBJS.setPredicate(p -> p.getData().get("id").contains(newValue.toLowerCase()));
                break;
        }

    }));
    //add search to choiceBox changes.
    choice.valueProperty().addListener(((observable, oldValue, newValue) -> {

        switch (choice.getValue().toString()) {
            case "FirstName":
                flInvoiceOBJS.setPredicate(p -> p.getCustomer().getFirstName().getValue().toLowerCase().contains(getSearchField().getText().toLowerCase()));
                break;
            case "LastName":
                flInvoiceOBJS.setPredicate(p -> p.getCustomer().getLastName().getValue().toLowerCase().contains(getSearchField().getText().toLowerCase()));
                break;
            case "Date":

                flInvoiceOBJS.setPredicate(p -> p.getGraphicalData("dateOfInvoice").getValue().toLowerCase().contains(getSearchField().getText().toLowerCase()));
                break;
            case "Manufacturer":
                flInvoiceOBJS.setPredicate(p -> p.getData().get("manufacturer").contains(getSearchField().getText().toLowerCase()));
                break;
            case "ID":
                flInvoiceOBJS.setPredicate(p -> p.getData().get("manufacturer").contains(getSearchField().getText().toLowerCase()));
                break;


        }
    }));

    //put filtered list through sorted list
    SortedList<invoiceOBJ> sortedCusts = new SortedList<>(flInvoiceOBJS);
    //add comparators (date)
    sortedCusts.comparatorProperty().bind(invoices.comparatorProperty());
    //finally, add the items to the table view to show
    invoices.setItems(sortedCusts);
}