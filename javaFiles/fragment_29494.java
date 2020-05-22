Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = getConnection();
      String query = "insert into table (column1,column2,column3,column4) values(?, ?, ?,?)";

      pstmt = conn.prepareStatement(query); 
      pstmt.setInt(1, 1); 
      pstmt.setDate(2, sqlDate); 
      pstmt.setInt(3, 3); 
      pstmt.setString(3, "test"); 
      pstmt.executeUpdate();
    } catch (Exception e) {
      //log the error messages log.error(e,e);
      //throw the actual exception upstream
    } finally {
      pstmt.close();
      conn.close();
    }