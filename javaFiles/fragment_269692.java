PGSQLConnection pgsqlConnection = null;
try {
    if (connection.isWrapperFor(PGSQLConnection .class)) {
        pgsqlConnection = connection.unwrap(PGSQLConnection .class);
    }
} catch (SQLException ex) {
    // do something
}