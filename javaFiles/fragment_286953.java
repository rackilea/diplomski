public void useExample(Example example) throws SQLException {
    String query = "begin example.useExample(?); end;";
    Connection connection = jdbcTemplate.getDataSource().getConnection();
    CallableStatement callableStatement = connection.prepareCall(query);

    Map<String, Class<?>> typeMap = connection.getTypeMap();
    typeMap.put(Example.SQL_OBJECT_TYPE_NAME, ExampleMapper.class);
    connection.setTypeMap(typeMap);

    // Manually convert the example object into an SQL type.
    Object[] exampleAttributes = new Object[]{example.ID, example.Name};
    Struct struct = connection.createStruct(type.getObjectType(), exampleAttributes);

    // Build the array using Oracle specific code.
    DelegatingConnection<OracleConnection> delegatingConnection = (DelegatingConnection<OracleConnection>) new DelegatingConnection(connection);
    OracleConnection oracleConnection = (OracleConnection) delegatingConnection.getInnermostDelegate();
    Object[] data = new Object[]{struct};
    Array array oracleConnection.createOracleArray(Example.SQL_TABLE_TYPE_NAME, data);

    // Set the input value (finally).
    callableStatement.setObject("p_example", array);

    callableStatement.execute();
}