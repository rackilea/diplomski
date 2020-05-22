public void actionPerformed(ActionEvent e) {
   // If the action is for getting data from DB then do,
   DefaultTableModel dtm = (DefaultTableModel) myTable.getModel();
   // int rowCount = dtm.getRowCount();
   /*
     for (int row = rowCount - 1; row >= 0; row--) {
        dtm.removeRow(row); 
   } */
   // or
   if(dtm.getRowCount() > 0) {
     dtm.setRowCount(0);
   }
// Add code to get your 3 rows from the database.
}