public void setDataVector(Vector newData, Vector columnNames) {
    if (newData == null)
        throw new IllegalArgumentException(
                "setDataVector() - Null parameter");
    dataVector = new Vector(0);
    // setColumnIdentifiers(columnNames);
    this.columnIdentifiers = columnNames;
    dataVector = newData;

    cellAtt = new DefaultCellAttribute(dataVector.size(),
            columnIdentifiers.size());

    newRowsAdded(new TableModelEvent(this, 0, getRowCount() - 1,
            TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
}