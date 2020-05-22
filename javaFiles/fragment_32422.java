JdbcRowSet rowSet = new JdbcRowSetImpl();
rowSet.setDataSourceName("jdbc/dbname");
// Or
rowSet.setUrl("jdbc:vendor://host:port/dbname");
rowSet.setUsername("username");
rowSet.setPassword("password");

rowSet.setCommand("SELECT id, name, value FROM tbl");
rowSet.execute();

while (rowSet.next()) {
    // ...
}