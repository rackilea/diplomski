if (cellType == HSSFCell.CELL_TYPE_BOOLEAN) {
    row.getCell(int).getBooleanCellValue();
} else if (cellType == HSSFCell.CELL_TYPE_ERROR) {
    row.getCell(int).getErrorCellValue();
} else if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
    row.getCell(int).getCellFormula();
} else if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
    row.getCell(int).getNumericCellValue();
} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
    row.getCell(int).getStringCellValue();
}