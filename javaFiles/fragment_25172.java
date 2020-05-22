for(Row row : sheet) {
   short minColIx = row.getFirstCellNum();
   short maxColIx = row.getLastCellNum();
   for(short colIx = minColIx; colIx<maxColIx; colIx++) {
     Cell c = row.getCell(colIx);
     if(c != null) {
        if(c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
           // add c.getNumericCellValue()
        }
     }
   }
}