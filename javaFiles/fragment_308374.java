public static class StringPropertyCell extends ListCell<StringProperty> {

    @Override
    protected void updateItem(StringProperty item, boolean empty) {
        super.updateItem(item, empty);
        textProperty().unbind();
        if (item != null && ! empty) {
            textProperty().bind(item);
        }
    }

}