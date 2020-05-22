DataFormat format = workbook.createDataFormat();
CellStyle testStyle = workbook.createCellStyle();
testStyle.setDataFormat(format.getFormat("@"));
String bigNumber = "9143018315313276189";
row.createCell(40).setCellStyle(testStyle);
row.getCell(40).setCellValue(bigNumber);