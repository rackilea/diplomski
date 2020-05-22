ComboBox<MyDataType> comboBox = new ComboBox<>();
comboBox.setCellFactory(listView -> new ListCell<MyDataType>() {

    private ImageView imageView = new ImageView();

    @Override
    public void updateItem(MyDataType item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            String imageURL = item.getImageURL();
            Image image = new Image(imageURL, true); // true means load in background
            imageView.setImage(image);
            setGraphic(imageView);
        }
    }
});