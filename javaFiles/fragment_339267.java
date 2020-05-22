XSSFWorkbook wb = new XSSFWorkbook();
CellStyle borderStyle = wb.createCellStyle();
borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
borderStyle.setBorderRight(CellStyle.BORDER_THIN);
borderStyle.setBorderTop(CellStyle.BORDER_THIN);
borderStyle.setAlignment(CellStyle.ALIGN_CENTER);
Sheet sheet = wb.createSheet("Test Sheet");
Row row = sheet.createRow(1);
for (int i = 1; i <= 5; ++i) {
    Cell cell = row.createCell(i);
    cell.setCellStyle(borderStyle);
    if (i == 1) {
        cell.setCellValue("Centred Text");
    } 
}
sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 5));