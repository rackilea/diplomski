listView.setCellFactory(cell -> {
    ListCell<ListItem> cel = new ListCell<ListItem>() {
        @Override
        protected void updateItem(ListItem item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                textFillProperty().bind(item.color);
                setFont(Font.font(16));
                setText(item.text);
            } else {
                setText("");
                textFillProperty().unbind();
                setTextFill(Color.BLACK);
            }
        }
    };
    return cel;
});