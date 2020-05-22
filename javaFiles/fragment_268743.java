String sql = "BEGIN INSERT INTO mytable(id, content) VALUES (seq_mytable.NEXTVAL(), ?) RETURNING id INTO ?; END;";

Connection connection = null;
CallableStatement statement = null;

try {
    connection = database.getConnection();
    statement = connection.prepareCall(sql);
    statement.setString(1, "test");
    statement.registerOutParameter(2, Types.NUMERIC);
    statement.execute();
    int id = statement.getInt(2);
    // ...