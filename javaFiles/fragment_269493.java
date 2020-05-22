ListView<String> listView = new ListView<>();
listView.getItems().addAll("a", "b", "c");
listView.setCellFactory(lv -> new ListCell<String>() {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText("");
        } else {
            setText(isSelected() ? "selected: " + item : item.toString());
        }
    }

    @Override
    public void updateSelected(boolean selected) {
        super.updateSelected(selected);
        if (!isEmpty()) {
            String item = getItem();
            setText(selected ? "selected: " + item : item.toString());
        }
    }

});