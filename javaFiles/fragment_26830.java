valueCol.setCellFactory(column -> {
    TreeTableCell<Item, Number> cell = new TreeTableCell<Item, Number>() {
        @Override
        protected void updateItem(Number value, boolean empty) {
            super.updateItem(value, empty);
            if (empty) {
                setText(null);
            } else {
                setText(value.toString());
            }
        }
    };

    cell.pseudoClassStateChanged(PseudoClass.getPseudoClass("centered"), true);

    return cell ;
});