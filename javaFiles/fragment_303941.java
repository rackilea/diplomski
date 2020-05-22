public void updateMethod() {
    Connection con = null;
    PreparedStatement stmt = null;
    int updateCount = null;

    try {
        con = BoneCPConnection.getConnectionPool().getConnection();
        stmt = con.prepareStatement("update example set id = ?");        
        stmt.setInt(1,1);
        updateCount = stmt.executeUpdate(query);
        con.commit();
    } catch (Exception e) {
       if(con != null){
        con.rollback();
       }
    } finally {

        try {
          if(stmt != null){
            stmt.close();
          }
          if(con != null){                
            con.close();
          }
        } catch (Exception e) {
            con = null;
        }        
    }
}