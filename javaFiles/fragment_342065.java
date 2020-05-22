TableView<Nepokretnost> table = new TableView<>();
TableColumn<Nepokretnost, Number> povrsinaCol = new TableColumn<>("Povrsina");
povrsinaCol.setCellValueFactory(cellData -> 
    new ReadOnlyDoubleWrapper(cellData.getValue().getPovrsina()));

povrsinaCol.setCellFactory(tc -> new TableCell<Nepokretnost, Number>() {
    @Override
    protected void updateItem(Number value, boolean empty) {
        super.updateItem(value, empty) ;
        if (empty) {
            setText(null);
        } else {
            setText(String.format("%0.2f", value.doubleValue()));
        }
    }
});