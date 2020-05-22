private ImageView imageView = new ImageView();

@Override
protected void updateItem(String item, boolean empty) {
    super.updateItem(item, empty);

    if (empty || item == null) {
        imageView.setImage(null);

        setGraphic(null);
        setText(null);
    } else {
        imageView.setImage(
                imageCollection.get(
                        item
                )
        );

        setText(constructLabel(SHORT_PREFIX, item, SUFFIX));
        setGraphic(imageView);
    }
}