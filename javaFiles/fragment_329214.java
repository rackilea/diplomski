public static Workbook createWorkBook(final Worksheet worksheet, final ListObject listObject) throws Exception {
    Workbook workbook = new Workbook();
    Cells cells = workbook.getWorksheets().get(0).getCells();

    Cells cellsTobeCopied = worksheet.getCells();

    int totalNoOfRows = listObject.getEndRow() - listObject.getStartRow() + 1;
    int totalNoOfColumns = listObject.getEndColumn() - listObject.getStartColumn() + 1;

    cells.setStandardHeight(cellsTobeCopied.getStandardHeight());
    cells.setStandardWidth(cellsTobeCopied.getStandardWidth());

    // Set height of each row as the height of actual rows of table
    for (int row = 0; row < totalNoOfRows; row++) {
        cells.setRowHeight(row, cellsTobeCopied.getRowHeight(row));
    }

    // Set width of each column as the width of actual columns of table
    for (int column = 0; column < totalNoOfColumns; column++) {
        cells.setColumnWidth(column, cellsTobeCopied.getColumnWidth(column));
    }

    // Copy data of table from worksheet to newly created workbook cells
    for (int row = 0; row < totalNoOfRows; row++) {
        for (int column = 0; column < totalNoOfColumns; column++) {
            Cell copiedFrom = worksheet.getCells().get(listObject.getStartRow() + row, listObject.getStartColumn() + column);
            Cell copyTo = cells.get(row, column);

            copyTo.setHtmlString(copiedFrom.getHtmlString());
        }
    }

    // Create table in newly created workbook
    ListObjectCollection tables = workbook.getWorksheets().get(0).getListObjects();
    tables.add(0, 0, totalNoOfRows - 1, totalNoOfColumns - 1, listObject.getShowHeaderRow());

    return workbook;
}