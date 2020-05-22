private Point find2DIndex(Object[][] array, Object search) {

    if (search == null || array == null) return null;

    for (int rowIndex = 0; rowIndex < array.length; rowIndex++ ) {
       Object[] row = array[rowIndex];
       if (row != null) {
          for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
             if (search.equals(row[columnIndex])) {
                 return new Point(rowIndex, columnIndex);
             }
          }
       }
    }
    return null; // value not found in array
 }