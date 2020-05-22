for(int i = 1; i <= totalRows; i++) {
    Row row = sheet.getRow(i);
    Cell cell = row.getCell(2);
    if (cell == null) {
        cell = row.createCell(2);
    }
    cell.setCellType(Cell.CELL_TYPE_STRING);
    cell.setCellValue("some value");
}