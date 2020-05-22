public static class SpanTableCell<S, T> extends PlainTableCell<S, T> {

    private ListChangeListener<TablePosition> selectedListener = c -> {
        while (c.next()) {
            if (c.wasAdded() || c.wasRemoved()) {
                updateSelection();
            }
        }
    };

    private WeakListChangeListener weakSelectedListener 
            = new WeakListChangeListener<>(selectedListener);

    private ChangeListener<TableView> tableViewListener = (t, old, value) -> {
        if (old != null && old.getSelectionModel() != null) {
            old.getSelectionModel().getSelectedIndices().removeListener(weakSelectedListener);
        }
        if (value != null && value.getSelectionModel() != null) {
            value.getSelectionModel().getSelectedIndices().addListener(weakSelectedListener);
        }
        updateSelection();
    };

    private WeakChangeListener weakTableViewListener = new WeakChangeListener(tableViewListener);

    public SpanTableCell() {
        tableViewProperty().addListener(weakTableViewListener);
    }

    private void updateSelection() {
        // super will handle (hard-coded not span condition for simplicity)
        if (!isInCellSelectionMode() || getIndex() != 0) return;
        // TableViewSelectionModel doesn't support row selection in
        // cellSelectionMode
        TableViewSelectionModel<S> selectionModel = getTableView()
                .getSelectionModel();
        boolean rowSelected = false; 
        ObservableList<TableColumn<S, ?>> columns = getTableView()
                .getVisibleLeafColumns();
        for (TableColumn<S, ?> tableColumn : columns) {
            rowSelected = rowSelected
                    || selectionModel.isSelected(getIndex(), tableColumn);
        }
        boolean finalSelected = rowSelected;
        Platform.runLater(() -> {
            // need to defer, super gets into the way
            updateSelected(finalSelected);
        });
    }

    private boolean isInCellSelectionMode() {
        TableView<S> tableView = getTableView();
        if (tableView == null) return false;
        TableSelectionModel<S> sm = tableView.getSelectionModel();
        return sm != null && sm.isCellSelectionEnabled();
    }

}