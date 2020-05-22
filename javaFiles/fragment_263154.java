DatabaseMetaData dbmd = connection.getMetaData()
try (ResultSet columns = dbmd.getColumns(null, null, "TableName", "%")) {
    while(columns.next()) {
        // get the info from the resultset (eg the java.sql.Types value):
        int dataType = columns.getInt("DATA_TYPE");
    }
}