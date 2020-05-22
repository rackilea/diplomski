// Cell styles
CellStyle park = workbook.createCellStyle();
park.setFillForegroundColor(IndexedColors.BLACK.getIndex());
park.setFillPattern(FillPatternType.SOLID_FOREGROUND);

CellStyle free = workbook.createCellStyle();
free.setFillForegroundColor(IndexedColors.GREEN.getIndex());
free.setFillPattern(FillPatternType.SOLID_FOREGROUND);

CellStyle unit= workbook.createCellStyle();
unit.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
unit.setFillPattern(FillPatternType.SOLID_FOREGROUND);

Sheet key=workbook.createSheet("Key");

Row row = key.createRow(1);
Cell cell11 = row.createCell(1);
cell11.setCellValue("Parking");
Cell cell12 = row.createCell(2);
cell12.setCellStyle(park);

row = key.createRow(2);
Cell cell21 = row.createCell(1);
cell21.setCellValue("Free");
Cell cell22 = row.createCell(2);
cell22.setCellStyle(free);

row = key.createRow(3);
Cell cell31 = row.createCell(1);
cell31.setCellValue("Units");
Cell cell32 = row.createCell(2);
cell32.setCellStyle(unit);