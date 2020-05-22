ObservableValue<Stock> markedItem = ...;
PseudoClass marked = PseudoClass.getPseudoClass("marked");
_variation.getStyleClass().add("variation");

mystockTable.setRowFactory(tv -> new TableRow<Stock>() {

    private void updatePseudoclass() {
        pseudoClassStateChanged(marked, !isEmpty() && getItem() == markedItem.getValue());
    }

    {
        markedItem.addListener(o -> updatePseudoclass());
    }

    @Override
    protected void updateItem(Stock item, boolean empty) {
        super.updateItem(item, empty);
        updatePseudoclass();
    }

});