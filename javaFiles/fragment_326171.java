private File writingToExcel() {
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("Sample-sheet");
    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);
    cell.setCellValue("My Sample Value");

    File file = new File(sheet.getSheetName());
    return file;
}