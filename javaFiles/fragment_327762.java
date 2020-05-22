String sql = "INSERT INTO newtable values (col1, col2,col3) values (?, ?, ?)";
Connection connection = new getConnection();
connection.setAutoCommit(false);
PreparedStatement ps = connection.prepareStatement(sql);

final int batchSize = 1000;
int count = 0;

while (rs.next()){

  ps.setString(1, rs.getString(1));
  ps.setString(2, rs.getString(2));
  ps.setString(3, rs.getString(3));
  ps.addBatch();

  if(++count % batchSize == 0) {
    ps.executeBatch();
  }
}
ps.executeBatch(); // insert remaining records
connection.commit();
ps.close();
connection.close();