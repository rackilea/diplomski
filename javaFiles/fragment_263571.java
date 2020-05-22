private void txtboxnoFocusLost(java.awt.event.FocusEvent evt) {
DBUtil util = new DBUtil();

try {
    Connection con = util.getConnection();
    PreparedStatement stmt = con.prepareStatement(
        "select box_no from dbo.soil_det where rm_id = ? and box_no = ?");
    stmt.setLong(1, Long.parseLong(tf_rm_id.getText()));
    stmt.setString(2, (txtboxno.getText()));       
    ResultSet rs=stmt.executeQuery();
    bool recordAdded = false;
    while(!rs.next()){            
       /// Do your insertion of new records
         recordAdded = true;
    }
    if( recordAdded ){
      JOptionPane.showMessageDialog(rootPane, "Record added");
    }else{
       JOptionPane.showMessageDialog(rootPane, "Record already exists");
    }
} catch (Exception ex) {
    Logger.getLogger(DATAENTRY.class.getName()).log(Level.SEVERE, null, ex);
}