private static DataSource dataSource;

    static {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(String.format("jdbc:mysql:///%s", DB_NAME));
        config.setUsername(DB_USER); 
        config.setPassword(DB_PASS);        
        config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.mysql.SocketFactory");
        config.addDataSourceProperty("cloudSqlInstance", CLOUD_SQL_CONNECTION_NAME);
        config.addDataSourceProperty("useSSL", "false");        
        config.setMaximumPoolSize(5);       
        config.setMinimumIdle(5);       
        config.setConnectionTimeout(10000); // 10 seconds       
        config.setIdleTimeout(600000); // 10 minutes        
        config.setMaxLifetime(1800000); // 30 minutes

        dataSource = new HikariDataSource(config);
    }

    private DataSource createConnectionPool() {
        return dataSource;
    }