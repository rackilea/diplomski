Statement createStatement() throws SQLException, ClassNotFoundException {
    Connection connection = dataSource.getConnection();

    ((org.postgresql.PGConnection) connection).addDataType("geometry", Class.forName("org.postgis.PGgeometry"));
    ((org.postgresql.PGConnection) connection).addDataType("box3d", Class.forName("org.postgis.PGbox3d"));

    return connection.createStatement();
}