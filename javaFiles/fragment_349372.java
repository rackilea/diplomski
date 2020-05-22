if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
    byte errorValue = cell.getErrorCellValue();
    switch(errorValue) {
    case ERROR_DIV_0:
        return "#DIV/0!";
    case ERROR_NA:
        return "#N/A";
    case ERROR_NAME:
        return "#NAME?";
    case ERROR_NULL:
        return "#NULL!";
    case ERROR_NUM:
        return "#NUM!";
    case ERROR_REF:
        return "#REF!";
    case ERROR_VALUE:
        return "#VALUE!";
    default:
        return "Unknown error value: " + errorValue + "!";
    }
} else {
    return new DataFormatter().formatCellValue(cell);
}