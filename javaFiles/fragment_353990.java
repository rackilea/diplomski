ContextMenu contextMenu = ...

TableColumn secondColumn = tableView.getColumns().get(1);

tableView.setOnKeyReleased(evt -> {
    if (evt.getCode() == KeyCode.ENTER) {
        Set<Node> rows = tableView.lookupAll(".table-row-cell");
        Optional<Cell> n = rows.stream().map(r -> (Cell) r).filter(Cell::isSelected).findFirst();

        if (n.isPresent()) {
            Optional<Node> node = n.get().getChildrenUnmodifiable().stream()
                    .filter(c -> c instanceof TableCell && ((TableCell) c).getTableColumn() == secondColumn)
                    .findFirst();

            if (node.isPresent()) {
                Node cell = node.get();
                Bounds b = cell.getLayoutBounds();
                contextMenu.show(cell, Side.BOTTOM, b.getWidth() / 2, b.getHeight() / -2);
            }
        }
    }
});