// Database Storage
    private ResultSet executeQuery(String statement, String... param) {

      String databaseName = "'HTML5', '1.0'," 
         +" 'Offline document storage', 100*1024";

      return ((DatabaseStorage) driver).executeSQL(databaseName, statement, (Object[]) param);
    }