firstNameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> cellData) {
        return cellData.getValue().firstNameProperty();
    }
});