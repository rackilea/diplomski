private void getConnection() throws ClassNotFoundException, SQLException {
  SQLiteDataSource ds = new SQLiteDataSource();
  ds.setUrl("jdbc:sqlite:SQLiteTest1.db");
  try {
   con = ds.getConnection();
   System.out.println("Connected.");
  } catch (Exception e) {
   e.printStackTrace();
  }
  initialise();
 }