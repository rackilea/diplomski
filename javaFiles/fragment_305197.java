class MyListCell extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)
            setGraphic(null);
        else {
            Image image = new Image(getClass().getResourceAsStream(item + ".png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            setGraphic(new HBox(imageView, new Label(item)));
        }

        setText("");
    }

}