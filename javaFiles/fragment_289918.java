public static boolean isRowEmpty(Row row){
         int firstCol = row.getFirstCellNum();
         for(int cnt = 0; cnt<4 ; cnt++){
             Cell cell = row.getCell(firstCol+cnt);
             if(cell!=null && cell.getCellType()!=Cell.CELL_TYPE_BLANK){
                 return false;
             }
         }
         return true;
    }

if(isRowEmpty(row)==false){
   compList.add(compItem);
}