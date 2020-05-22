// My answer assumes there is a constructor like this.
public Cell(int i) {
    listOfCells = new Cell[i];
}

public Cell deepCopy() {
    return deepCopy(this, new IdentityHashMap<Cell, Cell>());
}

private static Cell deepCopy(Cell original, Map<Cell, Cell> map) {
    if (original == null)
        return null;
    Cell copy = map.get(original);
    if (copy != null)
        return copy;
    int length = original.listOfCells.length;
    copy = new Cell(length);
    map.put(original, copy);
    for (int i = 0; i < length; i++)
        copy.listOfCells[i] = deepCopy(original.listOfCells[i], map);
    return copy;
}