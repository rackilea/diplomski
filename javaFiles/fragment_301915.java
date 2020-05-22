// create table
TableView<Person> table = new TableView<Person>();

// create columns
TableColumn<Person, String> nameCol = new TableColumn<Person, String>("Name");
nameCol.setCellValueFactory(new PropertyValueFactory("name"));

TableColumn<Person, Address> addressCol = new TableColumn<Person, String>("Address");
addressCol.setCellValueFactory(new PropertyValueFactory("address"));

// add columns 
table.getColumns().setAll(nameCol, addressCol);

// get data from db, return object List<Person> from DB 
ObservableList<Person> persons = getPersonsFromDB();
table.setItems(persons);

tableView.setOnMouseClicked((MouseEvent event) -> {
    if (event.getClickCount() > 1) {
        onEdit();
    }
});

public void onEdit() {
    // check the table's selected item and get selected item
    if (table.getSelectionModel().getSelectedItem() != null) {
        Person selectedPerson = table.getSelectionModel().getSelectedItem();
        nameTextField.setText(selectedPerson.getName());
        addressTextField.setText(selectedPerson.getAddress());
    }
}