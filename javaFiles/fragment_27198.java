private final ObservableList <TableItems> curnt_row = FXCollections.observableArrayList();

...

// TableView initialisation
tblItems.setItems(curnt_row);

col_customer.setCellValueFactory(new PropertyValueFactory<>("customer"));
col_mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
col_item.setCellValueFactory(new PropertyValueFactory<>("item"));
col_qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
col_unitprice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));
col_total.setCellValueFactory(new PropertyValueFactory<>("total"));

...

private void Add_details(){
    try {
        String Customer = txtCustomer.getText().trim();
        String Mobile = txtMobile.getText().trim();
        String Item  = txtItem.getText().trim();
        int unit_price = Integer.parseInt(txtUnitPrice.getText().trim());
        int qty = Integer.parseInt(txtQty.getText().trim());

       TableItems  t = new TableItems();

       t.setCustomer(Customer);
       t.setMobile(Mobile);
       t.setItem(Item);
       t.setUnit_price(String.valueOf(unit_price));
       t.setQty(String.valueOf(qty));
       t.setTotal(String.valueOf(total));

       curnt_row.add(t);
    } catch (Exception e) {
         e.printStackTrace();
    }
}