sheetsBox.setCellFactory(lv -> createSheetCell());
sheetsBox.setButtonCell(createSheetCell());

// ...

private ListCell<Sheet> createSheetCell() {
    return new ListCell<Sheet>() {
        @Override
        protected void updateItem(Sheet item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(item.getSheetName());
            }
        }        
    };
}