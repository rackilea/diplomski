//Create the workbook, and the font
HSSFWorkbook wb;
HSSFFont wbFont;
wbFont=wb.createFont();
wbFont.setCharSet(HSSFFont.ANSI_CHARSET); //Your Character encoding goes in the parameter
//Establish cell styles
HSSFCellStyle cellStyle =wb.createCellStyle();
cellStyle.setFont(wbFont);
//We create our cells with our data and with our specified format
HSSFCell cell =null;
cell = row.createCell(1);
cell.setCellStyle(cellStyle);
cell.setCellValue("MY DATA");
//Do the rest for whatever you might need for your workbook and then you create it