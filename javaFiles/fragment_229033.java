private void jButton_LocateMouseClicked(java.awt.event.MouseEvent evt) {                                            
   int column = 0;
   int rows[]=this.jTable_Search.getSelectedRows();

   for(int i=0;i<rows.length;i++)
   {
       String value = jTable_Search.getValueAt(rows[i], column).toString();
       System.out.println(value);
   }       
}