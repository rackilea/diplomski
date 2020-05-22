personIdTableGUI.setCellFactory(col -> new TextFieldTableCell<Person, String>(TextFormatter.IDENTITY_STRING_CONVERTER) {
    @Override
    public void updateItem(String name, boolean empty) {
        super.updateItem(name, empty);
        if (empty) {
            setEditable(false);
        } else {
            Person rowValue = getTableView().getItems().get(getIndex());
            setEditable( ! "John".equals(rowValue.getPersonName()) );
        }
    }
});