tableCol.setCellFactory(p -> {
    CheckBox checkBox = new CheckBox();
    TableCell<Person, Boolean> tableCell = new TableCell<Person, Boolean>() {

        @Override
        protected void updateItem(Boolean item, boolean empty) {

            super.updateItem(item, empty);
            if (empty || item == null) 
                setGraphic(null);
            else {
                setGraphic(checkBox);
                checkBox.setSelected(item);
            }
        }
    };

    checkBox.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> 
        validate(checkBox, (Person) cell.getTableRow().getItem(), event));

    checkBox.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
        if(event.getCode() == KeyCode.SPACE)
            validate(checkBox, (Person) cell.getTableRow().getItem(), event);
    });

    tableCell.setAlignment(Pos.CENTER);
    tableCell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

    return tableCell;
});