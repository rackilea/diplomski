public static double getCellValue(HSSFCell cell){

    switch (cell.getCachedFormulaResultType()){
        case Cell.CELL_TYPE_NUMERIC:
            return cell.getNumericCellValue();

            break;
        case Cell.CELL_TYPE_STRING:
            return Double.parse(cell.getStringCellValue());
           break;
        default:
            throw new RuntimeException("Data type not applicable");
    }
}