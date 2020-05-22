addressColumn1.setCellValueFactory(new Callback<CellDataFeatures<Client, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(CellDataFeatures<Client, String> c) {
            return new SimpleStringProperty(c.getValue().getAddress().getA1());                
        }
});