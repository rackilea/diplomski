String sql_insert = "INSERT INTO mytable(content) VALUES (?)";
String sql_currval = "SELECT seq_mytable.CURRVAL FROM dual";

Connection connection = null;
PreparedStatement statement = null;
Statement currvalStatement = null;
ResultSet currvalResultSet = null;

try {
    connection = database.getConnection();
    connection.setAutoCommit(false);
    statement = connection.prepareStatement(sql_insert);
    statement.setString(1, "test");
    statement.executeUpdate();
    currvalStatement = connection.createStatement();
    currvalResultSet = currvalStatement.executeQuery(sql_currval);
    if (currvalResultSet.next()) {
        int id = currvalResultSet.getInt(1);
    }
    connection.commit();
    // ...