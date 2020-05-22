public static Cell parseInput(String input, Table target) {
  Cell cellToReturn = new Cell();
  ...
  if (input.references(cell)) cell = target.getCell(i,j); //No more error!
  ...
  return cellToReturn;
}