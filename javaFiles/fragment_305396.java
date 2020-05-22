public static String getBreweryInfo (int Raz_ID) 
  throws SQLException 
  { 
    String sql = 
      "SELECT Nosaukums FROM Alus_razotaji WHERE ID = ?";//vaicajums
    try {
      Connection conn = DriverManager.getConnection("jdbc:default:connection:");
      PreparedStatement apstmt = conn.prepareStatement(sql);
      apstmt.setInt(1, Raz_ID); 
      ResultSet rset = apstmt.executeQuery();// SQL vaicājuma izpildīšana

      if (rset.next()) {
          return rset.getString(1);
      } 
    }
    catch (SQLException e) {
      System.err.println(e.getMessage()); //Kļūdu izvadīsana
    } 
    finally {
      rset.close();
      apstmt.close(); //Savienojuma aizvēršana
    } 
  }