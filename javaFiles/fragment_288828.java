Workbook SapWorkbook = new XSSFWorkbook(fs);
Sheet SapSheet = SapWorkbook.getSheet("Sheet1");
int rowCount = SapSheet.getLastRowNum() - SapSheet.getFirstRowNum();
for (int i = 0; i < rowCount + 1; i++) {
    Row row = SapSheet.getRow(i);
    if (key.equals(row.getCell(0).getStringCellValue())) {
        return row.getCell(1).getStringCellValue();
    }
}

throw new IllegalArgumentException(String.format("%s not found!", key));