private String getCellValue(Cell cell) {
    if (cell == null) {
        return null;
    }
    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
        return cell.getStringCellValue();
    } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
        return cell.getNumericCellValue() + "";
    } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
        return cell.getBooleanCellValue() + "";
    }else if(cell.getCellType() == Cell.CELL_TYPE_BLANK){
        return cell.getStringCellValue();
    }else if(cell.getCellType() == Cell.CELL_TYPE_ERROR){
        return cell.getErrorCellValue() + "";
    } 
    else {
        return null;
    }
}