public Row getRow(String rowId) {
    for (Row row : rows) {
        if (row.getId().equals(rowId)) {
            return row;
        }
    }
    // Either throw new IllegalArgumentException(); or:
    Row row = new Row(rowId);
    rows.add(row);
    return row;
}