Sheet sheet = workbook.getSheet("MyInterestingSheet");

 CellReference ref = new CellReference("B12");
 Row r = sheet.getRow(ref.getRow());
 if (r != null) {
    Cell c = r.getCell(ref.getCol());
 }