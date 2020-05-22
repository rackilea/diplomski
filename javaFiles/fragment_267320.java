/**
 * Prints out the specified cell.
 * 
 * @param cell the cell to print
 */
public void printCell(CellEntry cell) {
  String shortId = cell.getId().substring(cell.getId().lastIndexOf('/') + 1);
  out.println(" -- Cell(" + shortId + "/" + cell.getTitle().getPlainText()
      + ") formula(" + cell.getCell().getInputValue() + ") numeric("
      + cell.getCell().getNumericValue() + ") value("
      + cell.getCell().getValue() + ")");
}