Sheet s = wb.getSheetAt(0);
Row r = s.getRow(0);

int patchColumn = -1;
for (int cn=0; cn<r.getLastCellNum(); cn++) {
   Cell c = r.getCell(cn);
   if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
       // Can't be this cell - it's empty
       continue;
   }
   if (c.getCellType() == Cell.CELL_TYPE_STRING) {
      String text = c.getStringCellValue();
      if ("Patch".equals(text)) {
         patchColumn = cn;
         break;
      }
   }
}
if (patchColumn == -1) {
   throw new Exception("None of the cells in the first row were Patch");
}