protected static PreparedStatement prepareStatement(Connection connection,
        String sql, String idName, Object... values)
        throws SQLException {

    PreparedStatement statement = connection.prepareStatement(sql);

    setValues(statement, values);
    return statement;
}