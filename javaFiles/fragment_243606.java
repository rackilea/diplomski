CellStyle style = workBook.createCellStyle();
 style.setFillForegroundColor(HSSFColor.GOLD.index);
 style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

...

Row headerRow = sheet.createRow(0);
 headerRow.createCell(0).setCellValue(NYPG3Constants.FIRST_NAME);
 headerRow.createCell(1).setCellValue(NYPG3Constants.LAST_NAME);
 headerRow.createCell(2).setCellValue(NYPG3Constants.POLICY_NUMBER);
 headerRow.createCell(3).setCellValue(NYPG3Constants.ZIP_CODE);
 headerRow.createCell(4).setCellValue(NYPG3Constants.DATE_OF_BIRTH);

for (int c = 0; c < 5; c++) {
 headerRow.getCell(c).setCellStyle(style);
}