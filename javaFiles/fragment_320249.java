@Override 
  public void removeRow(int row) {
    Object[][] newData = new Object[data.length - 1][data[0].length];
    int rown = 0;
    for (int row1 = 0; row1 <data.length; row1++) {
      if (row1 != row) {
        for (int col = 0; col < data[0].length; col++) {
          newData[rown][col] = data[row1][col];
        }
        rown++;
      }
    }
    data = newData;
  }

  @Override 
  public void addRow(Object[] rowData) {
    Object[][] newData = new Object[data.length + 1][data[0].length];
    for (int row = 0; row <data.length; row++) {
      for (int col = 0; col < data[0].length; col++) {
        newData[row][col] = data[row][col];
      }
    }
    int maxCol = data[0].length < rowData.length?data[0].length:rowData.length;
    for (int col = 0; col < maxCol; col++) {
      newData[data.length][col] = rowData[col];
    }
    data = newData;
  }