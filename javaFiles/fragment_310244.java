public static String cellToString(XSSFCell cell) {
    String result = null;
    int type = cell.getCellType();
    switch (type) {
    case 0:
        result = String.valueOf(cell.getNumericCellValue());
        break;
    case 1:
        result = cell.getStringCellValue();
        break;
    default:
        throw new RuntimeException(
                "There are no support for this type of cell");
    }
    return result;
}