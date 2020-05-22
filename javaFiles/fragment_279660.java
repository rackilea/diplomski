tableColumnItemsValue.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
        double value = param.getValue().getItemValue();
        DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.getDefault()));
        return new SimpleStringProperty(df.format(value));
    }
});