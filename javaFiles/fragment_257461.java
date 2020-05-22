HSSFWorkbook wb = new HSSFWorkbook();
HSSFSheet sheet = wb.createSheet("Test");

Row row = sheet.createRow(0);

CellStyle style = wb.createCellStyle();
style.setLocked(true);
cell = row.createCell(0);
cell.setCellStyle(style);

// this is important as locking is pnly activated if sheet is protected
sheet.protectSheet("");