// Format to hold a time
DataFormat format = wb.createDataFormat();
CellStyle style = wb.createCellStyle();
style.setDataFormat(format.getFormat("HH:MM"));

// Set the cell to hold 18:00 and style
Cell cell = row.getCell(1);
cell.setCellValue(18.0/24.0);
cell.setCellStyle(style);