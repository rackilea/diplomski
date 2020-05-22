public void addElement(Person person) {
   data.add(person);
   int firstRow = data.size() - 1;
   int lastRow = firstRow;
   fireTableRowsInserted(firstRow, lastRow);
}

// public void fireTableDataChanged() {
//
// }