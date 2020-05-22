Row row;
Cell cell;
row=sheet.getRow(0); //get existing row
if(row==null)
row=sheet.createRow(0);//if row not present create row
cell=row.getCell(0);
if(cell==null)
cell=row.createCell(0);
cell.setCellType(Cell.CELL_TYPE_NUMERIC);
cell.setCellValue(0);//set cell value