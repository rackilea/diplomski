Row row = rowIterator.next();
for(int i = 0; i < row.getLastCellNum(); i++) {
    Cell cell = row.getCell(i);
    if(cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
       // handle not null values
    }else{
       // handle null values
    }
}