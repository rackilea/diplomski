Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;
try {        
    //...
} catch (SQLException ex) {
    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
} finally {
    try {
        rs.close();
    } catch (Exception exp) {
    }
    try {
        stmt.close();
    } catch (Exception exp) {
    }
    try {
        con.close();
    } catch (Exception exp) {
    }
}