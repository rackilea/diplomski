XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Calendar");
    CellStyle styleWhite = workbook.createCellStyle();
    styleWhite.setFillForegroundColor(IndexedColors.WHITE.getIndex());
    styleWhite.setFillPattern(CellStyle.SOLID_FOREGROUND);

    CellStyle styleYellow = workbook.createCellStyle();
    styleYellow.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    styleYellow.setFillPattern(CellStyle.SOLID_FOREGROUND);

    CellStyle styleRed = workbook.createCellStyle();
    styleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
    styleRed.setFillPattern(CellStyle.SOLID_FOREGROUND);

    for (int rowNum = 0; rowNum < n; rowNum++) {
        Row row = sheet.createRow(rowNum);
        for (int colNum = 0; colNum < m; colNum++) {
            Cell cell = row.createCell(colNum);
            cell.setCellValue(grid[rowNum][colNum]);
            cell.setCellStyle(styleWhite);
            if (res[rowNum][colNum] == CellEnum.BUSY.getValue()) {
                cell.setCellStyle(styleRed);
            } else if (res[rowNum][colNum] == CellEnum.Pass.getValue()) {
                cell.setCellStyle(styleYellow);
            } else {
                cell.setCellStyle(styleWhite);
            }
        }
    }