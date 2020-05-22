long key = -1L;
PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//to obtain the new primary key
// execute statement
int affectedRows = stmt.executeUpdate();
ResultSet rs = stmt.getGeneratedKeys();
// get generated key
if (rs != null && rs.next()) {
  key = rs.getLong(1);
}