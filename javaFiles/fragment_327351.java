friends.setCellFactory(listView -> new ListCell<String>() {
    private ImageView imageView = new ImageView();
    @Override
    public void updateItem(String friend, boolean empty) {
        super.updateItem(friend, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            Image image = getImageForFriend(friend);
            imageView.setImage(image);
            setText(friend);
            setGraphic(imageView);
        }
    }
});