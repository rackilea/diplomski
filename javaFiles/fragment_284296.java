colSelected.setCellFactory(c -> {
    TreeTableCell cell = new CheckBoxTreeTableCell() {

        @Override
        public void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty);
            if (getGraphic() != null) {
                getGraphic().disableProperty().bind(Bindings
                        .not(
                              getTreeTableView().editableProperty()
                             .and(getTableColumn().editableProperty())
                             .and(editableProperty())
                             .and(getTreeTableRow().editableProperty())
                    ));
            }
        }

    };
    return cell;
});