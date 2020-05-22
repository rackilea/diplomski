FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

// Set your cell formula here

switch (evaluator.evaluateFormulaCell(cell85014)) {
    case Cell.CELL_TYPE_NUMERIC:
        double x = cell85014.getNumericCellValue();
        // Set cell style here, based on numeric value,
        // as you already are doing in your code.
        // Watch out for floating point inaccuracies!
        break;
    default:
        System.err.println("Unexpected result type!");
        break;
}