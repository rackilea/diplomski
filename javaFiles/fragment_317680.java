DataFormatter fmt = new DataFormatter();    

Row r = sheet.getRow(10);
Cell c = r.getCell(2, Row.RETURN_BLANK_AS_NULL);
if (c == null) {
   // There's no value in this cell
} else {
   System.out.println("Cell K2 is " + fmt.formatCellValue(c));
}