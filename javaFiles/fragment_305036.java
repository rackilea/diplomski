Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(true);
      System.out.println("Opened database successfully");

      ResultSet rs = stmt.executeQuery("SELECT * FROM "+tablename);
      ResultSetMetaData rsmd = rs.getMetaData();
      FirstColumn = rsmd.getColumnName(1);
      String query = "DELETE FROM "+ tablename +" WHERE " + FirstColumn + " = '" + row + "'";
      stmt = c.createStatement();

      stmt.executeUpdate(query);

      stmt.close();
      c.close();