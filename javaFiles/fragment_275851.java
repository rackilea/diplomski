class MyTableModel extends DefaultTableModel {

   public MyTableModel(Object[] columnNames, int rowCount) {
      super(columnNames, rowCount);
   }

   public void setValueAt(Object[] valueArray, int row) {

      getDataVector().setElementAt(new Vector(Arrays.asList(valueArray)), row);     
   }
}