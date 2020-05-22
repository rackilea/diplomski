connection.setAutoCommit(false);
stmt.executeUpdate("insert into table1(\"id_auto_generated\", \"foo\") ...");
DatabaseResults results = stmt.getGeneratedKeys();
// extract the id from the results
stmt.executeUpdate("insert into table2(\"table1_id\", \"boo\") ...");
... many more stmts here
connection.commit();
connection.setAutoCommit(true);