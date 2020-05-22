String   catalog          = null;
    String   schemaPattern    = null;
    String   tableNamePattern = null;
    String[] types            = null;
    String   columnNamePattern = null;

    DatabaseMetaData databaseMetaData = con.getMetaData();
    result = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types );
    while(result.next()) {
        String tableName =result.getString(3);
        result1= databaseMetaData.getColumns(catalog, schemaPattern, tableName, columnNamePattern); 
        while(result1.next()) {
            String columnName = result1.getString(4);
            String    columnType = result1.getString(6);            
        }
    }
For More info : http://tutorials.jenkov.com/jdbc/databasemetadata.html