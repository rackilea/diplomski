TableColumn<Foo, LocalDateTime> ldtCol = new TableColumn<Foo, LocalDateTime>("LDT");
ldtCol.setCellValueFactory(cellData -> cellData.getValue().ldtProperty());
ldtCol.setCellFactory(col -> new TableCell<Foo, LocalDateTime>() {
    @Override
    protected void updateItem(LocalDateTime item, boolean empty) {

        super.updateItem(item, empty);
        if (empty)
            setText(null);
        else
            setText(String.format(item.format(formatter)));
    }
});