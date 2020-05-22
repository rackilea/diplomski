colName.setCellFactory(c -> {
    TreeTableCell cell = new TextFieldTreeTableCell() {

        @Override
        public void startEdit() {
            if (getTreeTableRow() != null && !getTreeTableRow().isEditable()) return;
            super.startEdit();
        }

    };
    return cell;
});