try(Connection con = pool.getConnection();
    PreparedStatement ps = con.prepareStatement("SELECT * FROM whatever");
    ResultSet rs = ps.executeQuery()) {

  while(rs.next()) {
    //handle resultset
  }
}