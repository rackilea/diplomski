// Do this once for the workbook
CellStyle safeFormulaStyle = workbook.createCellStyle();
safeFormulaStyle.setQuotePrefixed(true);


// Per cell
String cellValue = cell.getStringCellValue();
if( cellValue != null && "=-+@".indexOf(cellValue.charAt(0)) >= 0 ) {
    cell.setCellStyle(safeFormulaStyle);
}