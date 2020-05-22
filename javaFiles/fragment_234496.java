@Override
protected void updateItem(String item, boolean empty) {
    super.updateItem(item, empty);
    if (!empty && item != null) {
        // Show the Text Field
        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
...