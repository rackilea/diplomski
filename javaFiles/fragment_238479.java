@Override
public Object getValueAt(int row, int col) {
  if (row > getRowCount()) {
     // throw an exception
  }
  RowItem rowItem = rowItemList.get(row);
  switch (col) {
  case 0:
     return rowItem.getName();
  case 1:
     return rowItem.getLastSpecies();
  case 2:
     return rowItem.getAge();
  }
  return null; // or throw an exception
}