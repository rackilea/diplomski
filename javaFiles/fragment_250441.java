public void actionPerformed(ActionEvent e) {


   if(e.getSource()==jButton1){



               jTable1.getModel().addTableModelListener(new TableModelListener() {
  public void tableChanged(TableModelEvent e) {
      myDbConnection dbconnect;
    dbconnect = new myDbConnection();
         ResultSet resultSet =null;
        resultSet = dbconnect.excuteQuery("SELECT id, area,location, status1 FROM pledges ");
       int row = e.getFirstRow();
    int column = e.getColumn();
    TableModel model = (TableModel)e.getSource();
    String columnName = model.getColumnName(column);
    Object data = model.getValueAt(row, column);
    int viewRow = jTable1.getSelectedRow(); // view row with sort
    int modelRow = jTable1.convertRowIndexToModel(viewRow); // convert
    dbconnect.excuteUpdate("update pledges set area ='" + data + "' where id = '"+jTable1.getModel().getValueAt(modelRow,0) +"'"  );
      System.out.println("Table value changed "+data);
  }
});