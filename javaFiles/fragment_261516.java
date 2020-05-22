@Override public void initialize(URL url, ResourceBundle resourceBundle) {
  if (item_Table != null) {
    item_Priority.setCellValueFactory(new PropertyValueFactory<Products, String>("ItemPriority"));
    item_Name.setCellValueFactory(new PropertyValueFactory<Products, String>("ItemName"));
    item_Qty.setCellValueFactory(new PropertyValueFactory<Products, Integer>("ItemQty"));
    item_Price.setCellValueFactory(new PropertyValueFactory<Products, Double>("ItemPrice"));
    item_Table.setItems(getProduct());
  }
}