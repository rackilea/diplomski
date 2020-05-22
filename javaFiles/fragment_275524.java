public static boolean isColumnEmpty(Sheet sheet, int columnIndex, int startRow) {
    int firstRow = sheet.getFirstRowNum();
    int lastRow = sheet.getLastRowNum();
    // No need to check rows above the first row
    startRow = Math.max(startRow, firstRow);
    int numRows = sheet.getPhysicalNumberOfRows();

    // Compute an estimate of the number of rows that each method
    // will access.
    // Assume the cost to access one row is the same
    // between an explicit getRow() or through the rowIterator.
    // Assume physical rows are uniformly spaced, which is unlikely true
    // but the best estimate possible without iterating over the rows.
    double rowDensity = (lastRow - firstRow + 1) / numRows;
    double estimatedForEachLoopCost = numRows;
    double estimatedForLoopCost = (lastRow - startRow) + 1) * rowDensity;
    if (estimatedForEachLoopCost < estimatedForLoopCost) {
        // for-each iteration
        for (Row row : sheet) {
            if (row.getRowNum() < startRow) continue;
            Cell cell = row.getCell(columnIndex, Row.RETURN_BLANK_AS_NULL);
            if (cell != null) {
                return false;
            }
        }
        return true;
    } else {
        for (int r=startRow; r<=lastRow; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            Cell cell = row.getCell(columnIndex, Row.RETURN_BLANK_AS_NULL);
            if (cell != null) {
                return false;
            }
        }
        return true;
    }
}