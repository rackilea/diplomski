@Override
protected void updateItem(Product item, boolean empty) {
    super.updateItem(item, empty);
    setText(null);
    setGraphic(null);

    if (item != null && !empty) {
        description.setText(item.getDescription());
        imageView.setImage(...);
        setGraphic(hBox);
    }
}