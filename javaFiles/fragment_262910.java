private static HikariConfig dbConfig;
static { //keep this the same
    dbConfig = new HikariConfig();
    dbConfig.setJdbcUrl("jdbc:mysql://localhost:3306/" + config.get("database.database"));
    dbConfig.setUsername(config.get("database.username"));
    dbConfig.setPassword(config.get("database.password"));
    dbConfig.setDriverClassName("com.mysql.jdbc.Driver");
    dbConfig.addDataSourceProperty("cachePrepStmts", "true");
    dbConfig.addDataSourceProperty("prepStmtCacheSize", "250");
    dbConfig.addDataSourceProperty( "prepStmtCacheSqlLimit", "2048");
}

private static HikariDataSource ds = new HikariDataSource(dbConfig); //intialize here with your newly created HikariConfig object