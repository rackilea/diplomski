public List<Row> generateRows(SortedMap<Column, Set<Cell>> map) {
    List<Row> done = new ArrayList<Row>();
    List<Column> columnsToDo = new LinkedList<Column>(map.keySet());
    List<Cell> partialRow = new LinkedList<Cell>();
    generateRowsRec(map, columnsToDo, partialRow, done);
    return done;
}
void generateRowsRec(SortedMap<Column, Set<Cell>> map, List<Column> columnsToDo, List<Cell> partialRow, List<Row> done) {
    if (columnsToDo.isEmpty()) {
        done.add(new Row(partialRow));
        return;
    }
    Column firstColumn = columnsToDo.remove(0); // Step A
    for (Cell cell : map.get(firstColumn)) {
        partialRow.add(cell); // Step B
        generateRowsRec(map, columnsToDo, partialRow, done);
        partialRow.remove(partialRow.size() - 1); // Unstep B
    }
    columnsToDo.add(0, firstColumn); // Unstep A
}