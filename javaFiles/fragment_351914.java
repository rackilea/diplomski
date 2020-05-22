HSSFRow row = sheet.createRow(sheet.getLastRowNum());
HSSFCell cell = row.createCell(0);
HSSFCellStyle style = workbook.createCellStyle();
style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
cell.setCellStyle(style);
cell.setCellValue(Float.parseFloat("21.5"));