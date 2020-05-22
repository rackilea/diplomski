TableView<Item> table = new TableView<>();

// ...

PseudoClass lastRow = PseudoClass.getPseudoClass("last-row");

table.setRowFactory(tv -> new TableRow<Item>() {
    @Override
    public void updateIndex(int index) {
        super.updateIndex(index);
        pseudoClassStateChanged(lastRow, 
            index >= 0 && index == table.getItems().size() - 1);
    }
});