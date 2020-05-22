col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Test, String>,
             ObservableValue<String>>() {
     public ObservableValue<String> call(TableColumn.CellDataFeatures<Test, String> t) {
         // t.getValue() returns the Test instance for a particular TableView row
         return t.getValue().testProperty();
         // or
         return new SimpleStringProperty(t.getValue().getMessage());
     }
  });