public static void databaseInfoTable(int age,int point) throws Exception {
  PreparedStatement prepInfo = conn.prepareStatement(
     "insert into Info (age, point)values (?, ?)");
        prepInfo.setInt(1, age);
        prepInfo.setInt(2, point);
        prepInfo.addBatch();
conn.setAutoCommit(false);
prep.executeBatch();
conn.commit();
  }