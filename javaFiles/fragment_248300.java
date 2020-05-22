try (Connection con = datasource.getConnection();) {

 con.setAutoCommit(false);
 // insert logic
 con.commit();
 } catch (SQLException e) {
  // handle exception
  con.rollback();
 }