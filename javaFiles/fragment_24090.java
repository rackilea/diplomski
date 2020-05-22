private static void printForeignKeys(Connection connection, String CUSTOMERS) throws SQLException {
    System.out.println("Foreign Keys are\n");
    DatabaseMetaData dbMeta= connection.getMetaData();
    ResultSet foreignKeys = dbMeta.getImportedKeys(connection.getCatalog(), null, CUSTOMERS);
    while (foreignKeys.next()) {
        String fkName = foreignKeys.getString("FK_NAME");
        String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
        System.out.println(fkName + "." + fkColumnName);
    }
}