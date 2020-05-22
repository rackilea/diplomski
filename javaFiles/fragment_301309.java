public final class WeirdAlign {

    private WeirdAlign() {
    }

    public static final Predicate<Node> ALL_PREDICATE = n -> true;

    public static void setCombinedCenterJustify(GridPane gridPane, Predicate<Node> predicate) {
        InvalidationListener listener = o -> {
            Node n = (Node) ((ReadOnlyProperty) o).getBean();
            updateGridPaneColumn(gridPane, getGridPaneColumn(n), predicate);
        };
        ObservableList<Node> children = gridPane.getChildren();

        for (Node n : children) {
            if (predicate.test(n)) {
                n.layoutBoundsProperty().addListener(listener);
            }
        }

        int[] columns = children.stream().filter(predicate).mapToInt(WeirdAlign::getGridPaneColumn).distinct().toArray();
        for (int i : columns) {
            updateGridPaneColumn(gridPane, i, predicate);
        }

        children.addListener((ListChangeListener.Change<? extends Node> c) -> {
            Set<Integer> columnsToUpdate = new HashSet<>();
            while (c.next()) {
                if (c.wasRemoved()) {
                    for (Node n : c.getRemoved()) {
                        if (predicate.test(n)) {
                            n.layoutBoundsProperty().removeListener(listener);
                            columnsToUpdate.add(getGridPaneColumn(n));
                        }
                    }
                }
                if (c.wasAdded()) {
                    for (Node n : c.getAddedSubList()) {
                        if (predicate.test(n)) {
                            n.layoutBoundsProperty().addListener(listener);
                            columnsToUpdate.add(getGridPaneColumn(n));
                        }
                    }
                }
            }
            for (Integer i : columnsToUpdate) {
                updateGridPaneColumn(gridPane, i, predicate);
            }
        });
    }

    /**
     * This method is only here for FXMLLoader.
     */
    public static Predicate<Node> getCombinedCenterJustify(GridPane node) {
        throw new UnsupportedOperationException();
    }

    public static void updateGridPaneColumn(GridPane gridPane, int column, Predicate<Node> predicate) {
        double maxSize = 0;
        for (Node child : gridPane.getChildren()) {
            if (column == getGridPaneColumn(child) && predicate.test(child)) {
                double width = child.getLayoutBounds().getWidth();
                if (width > maxSize) {
                    maxSize = width;
                }
            }
        }
        for (Node child : gridPane.getChildren()) {
            if (column == getGridPaneColumn(child) && predicate.test(child)) {
                child.setTranslateX((child.getLayoutBounds().getWidth() - maxSize) / 2);
            }
        }
    }

    public static int getGridPaneColumn(Node node) {
        Integer c = GridPane.getColumnIndex(node);
        return c == null ? 0 : c;
    }

}