listView.setCellFactory(column -> {
    return new ListCell<File>() {

        private final TextField textField = new TextField();

        protected void updateItem(File item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setDisable(false);
                setGraphic(null);
            } else {
                setDisable(true);
                textField.setText(item.getName());
                setGraphic(textField);
            }
        }
    };
});