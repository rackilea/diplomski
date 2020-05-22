CellReference cr = new CellReference(entry.getKey());
int r = cr.getRow();
int c = cr.getCol();

Row row = sheet.getRow(r);
if (row == null)
    row = sheet.createRow(r);
Cell cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);
cell.setCellValue(entry.getValue());