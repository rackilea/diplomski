TableColumn<Person,String> firstNameCol = new TableColumn<Person,String>("First Name");
firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
     public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
         // p.getValue() returns the Person instance for a particular TableView row
         return p.getValue().firstNameProperty();
     }
  });
}