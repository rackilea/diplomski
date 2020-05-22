public class Table {
  List<Cell> cells;

  public Table() {
    while (someCondition)
      parseInput(nextInput);
  }

  public Cell getCell(int i, int j) {
    ...
  }

  public static Cell parseInput(String input) {
    Cell cellToReturn = new Cell();
    ...
    if (input.references(cell)) cell = getCell(i,j); //Error here!
    ...
    return cellToReturn;
  }
}