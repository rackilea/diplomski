class MyTableModel extends DefaultTableModel {

   public MyTableModel(Object[] columnNames, int rowCount) {
      super(columnNames, rowCount);
   }

   public void setValueAt(Object[] valueArray, int row) {
      int column = 0;
      for (Object cellValue: valueArray) {
         setValueAt(cellValue, row, column);
         column++;
      }
   }
}