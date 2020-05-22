public static boolean isColumnEmpty(Sheet sheet, int columnIndex, int startRow) {
    for (Row row : sheet) {
        if (row.getRowNum() < startRow) continue;
        Cell cell = row.getCell(columnIndex, Row.RETURN_BLANK_AS_NULL);
        if (cell != null) {
            return false;
        }
    }
    return true;
}