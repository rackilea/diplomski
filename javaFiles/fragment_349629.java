// Decide which rows to process
int rowStart = Math.min(15, sheet.getFirstRowNum());
int rowEnd = Math.max(1400, sheet.getLastRowNum());

for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
   Row r = sheet.getRow(rowNum);
   if (r == null) {
      // Handle empty row
      continue;
   }

   int lastColumn = Math.max(r.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);

   for (int cn = 0; cn < lastColumn; cn++) {
      Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
      if (c == null) {
         // The spreadsheet is empty in this cell
      } else {
         // Do something useful with the cell's contents
      }
   }
}