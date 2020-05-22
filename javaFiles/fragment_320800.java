for(int row = tblSchedule.getRowCount() - 1; row >= 0; row--)
{
 DefaultTableModel dm = (DefaultTableModel) tbl.getModel();
 Boolean ifTrue = (Boolean) tbl.getValueAt(row, 5) == true;

 if (ifTrue) 
 {
     System.out.println("Row checked " + row);
     getSelectedRows(row);
     dm.removeRow(row);
 }
 else
 {
      System.out.printf("Row %s is not checked \n", row);
 }
}