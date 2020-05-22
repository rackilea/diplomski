private void deleteSelectedRows(){
       try {
          String sql = "DELETE from user where ? = ?";
          pst = conn.prepareStatement(sql);
          pst.setString(1, searchTxt.getText());
          pst.setString(2, searchTxt.getText());

         ((DefaultTableModel) userTable.getModel()).removeRow(userTable.getSelectedRow());

         pst.execute();
    } catch (Exception e){
         JOptionPane.showMessageDialog(null, e);
    }
 }