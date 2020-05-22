public boolean checkIfVideoExist(String address) throws SQLException {
  int count = 0;
  PreparedStatement stmt = null;
  ResultSet rset = null;
  try {
    stmt = connection.prepareStatement(
        "SELECT Count(VideoID) from VIDEO WHERE Address=?");
    stmt.setString(1, address);
    rset = stmt.executeQuery();
    if (rset.next())
      count = rset.getInt(1);
    return count > 0;
  } finally {
    if(rset != null) {
      try {
        rset.close();
      } catch(SQLException e) {
        e.printStackTrace();
      }
    }        
    if(stmt != null) {
      try {
        stmt.close();
      } catch(SQLException e) {
        e.printStackTrace();
      }
    }        
  }    
}