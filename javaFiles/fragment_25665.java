Row r = getRow(); // Logic here to get the row of interest

// Iterate over all cells in the row, up to at least the 10th column
int lastColumn = Math.max(r.getLastCellNum(), 10);

for (int cn = 0; cn < lastColumn; cn++) {
      Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
      if (c == null) {
         // The spreadsheet is empty in this cell
      } else {
         // Do something useful with the cell's contents
         // eg...
         System.out.println("There is data in cell " + (new CellReference(c)).formatAsString());
      }
}