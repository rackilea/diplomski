public void actionPerformed(ActionEvent e) {
    if(mytable.getSelectedRow() != -1) { 
      removeRow(mytable.getSelectedRow());
      rftl2.fireTableRowsDeleted(mytable.getSelectedRow(), mytable.getSelectedRow());
    } else {
      JOptionPane.showMessageDialog(null, "No Row Selected");
       return;
    }

    //Now, Delete from text file too
    deleteFromFile();
 }