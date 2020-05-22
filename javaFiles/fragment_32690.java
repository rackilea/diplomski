firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Data, String>, ObservableValue<String>>() {
     public ObservableValue<String> call(CellDataFeatures<Data, String> data) {
         // data.getValue() returns the Data instance for a particular TableView row
         return data.getValue().getUser().firstNameProperty();
     }
  });
}