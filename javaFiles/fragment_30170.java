int[][] gridPaneNodes = new int[gridPaneWidth][gridPaneHeight] ;
for (Node child : gridPane.getChildren()) {
    Integer column = GridPane.getColumnIndex(child);
    Integer row = GridPane.getRowIndex(child);
    if (column != null && row != null) {
        gridPaneNodes[column][row] = child ;
    }
}