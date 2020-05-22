public boolean addColumns(ColumnText[] columns) throws DocumentException {
    int status = ColumnText.NO_MORE_TEXT;
    for (ColumnText column : columns) {
        if (ColumnText.hasMoreText(column.go()))
            status = ColumnText.NO_MORE_COLUMN;
    }
    return ColumnText.hasMoreText(status);
}