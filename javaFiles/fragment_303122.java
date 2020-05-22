XSSFRow row = null;
int rowCounter = 0;
int cellCounter = 0;
for (int i = 0; i < lotto.length; i++) {
   if ((i % 6) == 0) {
      cellCounter = 0;
      row = (XSSFRow) sheet.createRow(rowCounter);
      rowCounter++;
   }
   row.createCell(cellCounter).setCellValue(lotto[i]);
   cellCounter++;
}