public class TableViewUtil {
    public static void centerColumn(TableView<?> tableView, TableColumn<?, ?> column) {
        findScrollBar(tableView, Orientation.HORIZONTAL).ifPresent(scroll -> {
            final double offset = getLeftOffset(tableView, column);
            final double target = offset - tableView.getWidth() / 2.0 + column.getWidth() / 2.0;
            scroll.setValue(Math.min(Math.max(target, scroll.getMin()), scroll.getMax()));
        });
    }

    private static double getLeftOffset(TableView<?> tableView, TableColumn<?, ?> column) {
        double offset = 0.0;
        for (TableColumn<?,?> c: tableView.getColumns()) {
            if (c == column) return offset;
            if (c.isVisible()) offset += c.getWidth();
        }
        return offset;
    }

    private static Optional<ScrollBar> findScrollBar(TableView<?> tableView, Orientation orientation) {
        return tableView.lookupAll(".scroll-bar").stream()
                .filter(node -> node instanceof ScrollBar && ((ScrollBar)node).getOrientation() == orientation)
                .map(node -> ((ScrollBar)node))
                .findFirst();
    }
}