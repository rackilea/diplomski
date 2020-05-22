playerNamesColumn.setCellFactory(col -> new TableCell<Game, ObservableList<String>>() {

    private final ListView<String> listView = new ListView<>();

    @Override
    protected void updateItem(ObservableList<String> playerNames, boolean empty) {
        super.updateItem(playerNames, empty);
        if (empty) {
            setGraphic(null);
        } else {
            listView.setItems(playerNames);
            setGraphic(listView);
        }
    }
});