ListView<Album> albumList = new ListView<>();
albumList.setCellFactory((ListView<Album> lv) -> 
    new ListCell<Album>() {
        @Override
        public void updateItem(Album album, boolean empty) {
            super.updateItem(album, empty);
            if (empty) {
                setText(null);
            } else {
                // use whatever data you need from the album
                // object to get the correct displayed value:
                setText(album.getTitle());
            }
        }
    }
);

albumList.getSelectionModel().selectedItemProperty()
    .addListener((ObservableValue<? extends Album> obs, Album oldAlbum, Album selectedAlbum) -> {
        if (selectedAlbum != null) {
            // do something with selectedAlbum
        }
);