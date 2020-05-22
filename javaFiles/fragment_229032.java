private void jButton_LocateMouseClicked(java.awt.event.MouseEvent evt) {                                            
   int column = 0;
   int rows[]=this.jTable_Search.getSelectedRows();

   for(int i=0;i<rows.length;i++)
   {
       int modelRow = jTable_Search.convertRowIndexToModel(rows[i]);
       String value = jTable_Search.getModel().getValueAt(modelRow, column).toString();
       System.out.println(value);
   }       
}