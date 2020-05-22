private Connection connect = null;
 private Statement statement = null;
 try {
    Class.forName("com.mysql.jdbc.Driver");
    connect =
      DriverManager.getConnection("jdbc:mysql://localhost/xyz?"
          + "user=sqluser&password=sqluserpw");
      String query = "INSERT INTO records (id, time) VALUES (?, ?)";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt (1, null);
      preparedStmt.setDate (2, new java.util.Date());
      preparedStmt.executeUpdate();
    } catch (SQLException e) {
      ...
    }