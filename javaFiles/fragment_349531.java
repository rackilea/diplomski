PreparedStatement stmt = c.prepareStatement
      ("insert into COMPANY values(?,?,?,?,?)");
      stmt.setInt(1,1);
      stmt.setString(2,"Paul");
      stmt.setInt(3,32);
      stmt.setString(4, "California");
      stmt.setBigDecimal(5, 20000.00);
      stmt.executeUpdate();