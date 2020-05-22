conn.setAutoCommit(false);
// statements prepared and executed here
// maybe no need for batch operations
...
conn.commit();
conn.setAutoCommit(true);