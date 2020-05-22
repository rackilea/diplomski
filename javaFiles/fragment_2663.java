firstNameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person,String>, ObservableValue<String>>() {
      @Override
      public ObservableValue<String> call(CellDataFeatures<Person, String> cdf) {
        return cdf.getValue().firstNameProperty();
      }
    });