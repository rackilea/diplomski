arrayListCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<PropertyDifference, DifferenceFileList>, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<PropertyDifference, DifferenceFileList>, String> p) {
            return new SimpleStringProperty(Arrays.toString(p.getValue().getValue().getFileList().toArray()));
        }
    });