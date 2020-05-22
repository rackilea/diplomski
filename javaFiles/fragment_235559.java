table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
  public void valueChanged(ListSelectionEvent e) 
  {
     ... // fill data into table2
     tableModel2.fireTableDataChanged(); // update the display
  }
});