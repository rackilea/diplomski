playerNamesColumn.setCellFactory(col -> new TableCell<Game, ObservableList<String>>() {
    @Override
    protected void updateItem(ObservableList<String> playerNames, boolean empty) {
        super.updateItem(playerNames, empty);
        if (empty) {
            setText(null);
        } else {
            setText(String.join(", ", playerNames));
        }
    }
});