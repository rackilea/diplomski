FileInputStream fis = new FileInputStream("/somepath/test.xls");
Workbook wb = new HSSFWorkbook(fis); //or new XSSFWorkbook("/somepath/test.xls")
Sheet sheet = wb.getSheetAt(0);
FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

// suppose your formula is in B3
CellReference cellReference = new CellReference("B3"); 
Row row = sheet.getRow(cellReference.getRow());
Cell cell = row.getCell(cellReference.getCol()); 

if (cell!=null) {
    switch (evaluator.evaluateFormulaCell(cell)) {
        case Cell.CELL_TYPE_BOOLEAN:
            System.out.println(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_NUMERIC:
            System.out.println(cell.getNumericCellValue());
            break;
        case Cell.CELL_TYPE_STRING:
            System.out.println(cell.getStringCellValue());
            break;
        case Cell.CELL_TYPE_BLANK:
            break;
        case Cell.CELL_TYPE_ERROR:
            System.out.println(cell.getErrorCellValue());
            break;

        // CELL_TYPE_FORMULA will never occur
        case Cell.CELL_TYPE_FORMULA: 
            break;
    }
}