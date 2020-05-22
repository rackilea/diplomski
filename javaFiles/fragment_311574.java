String file = "c:\\poitest.xlsx";
FileOutputStream outputStream = new FileOutputStream(file);
Workbook wb = new XSSFWorkbook();

CellStyle unlockedCellStyle = wb.createCellStyle();
unlockedCellStyle.setLocked(false);

Sheet sheet = wb.createSheet();
sheet.protectSheet("password");
Row row = sheet.createRow(0);
Cell cell = row.createCell(0);
cell.setCellValue("TEST");
cell.setCellStyle(unlockedCellStyle);

wb.write(outputStream);
outputStream.close();