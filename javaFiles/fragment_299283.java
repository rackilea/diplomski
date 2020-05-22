FormulaEvaluator evaluator = book.getCreationHelper().createFormulaEvaluator();
for (Sheet sheet : book) {
    for (Row r : sheet) {
        for (Cell c : r) {
            if (c.getCellType() == Cell.CELL_TYPE_FORMULA) {
System.out.println(c.getAddress() + ":" + c.getCellFormula());
                evaluator.evaluateFormulaCell(c);
            }
        }
    }
}