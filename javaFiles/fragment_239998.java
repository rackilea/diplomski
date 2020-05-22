int alignRow = 1;
for (Node n : gridPane.getChildren()) {
    Integer row = GridPane.getRowIndex(n);
    int rowNumber = row == null ? 0 : rowNumber.intValue();
    if (rowNumber = alignRow) {
        GridPane.setHalignment(n, HPos.CENTER);
    }
}