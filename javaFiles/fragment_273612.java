ObjectProperty<JSong> currentSong;
TableView<JSong> songsTable;
currentSong.addListener(new ChangeListener<JSong>() {

        @Override
        public void changed(ObservableValue<? extends JSong> observable,
                JSong oldValue, JSong newValue) {
            songsTable.getSelectionModel().select(newValue);

        }
    });