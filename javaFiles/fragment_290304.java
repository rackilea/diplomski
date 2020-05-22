priceProductColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

priceProductColumn.setCellFactory(col -> 
    new TableCell<Product, Number>() {
        @Override 
        public void updateItem(Number price, boolean empty) {
            super.updateItem(price, empty);
            if (empty) {
                setText(null);
            } else {
                setText(String.format("US$%.2f", price.doubleValue()));
            }
        }
    });