Connection conn = ds.getConnection()
try {
  conn.createStatement().executeUpdate("CREATE TABLE ....");
} finally {
  conn.close();
} catch(SQLException ignore) {
  // ignore exception, not much can go wrong here except for the table already existing.

  // If you don't mind making vendor specific logic, check the error message for "already exists" or some equivalent
  if(!ignore.getMessage().contains("already exists"))
    throw ignore;
}