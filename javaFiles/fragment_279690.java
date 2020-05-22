@Bean
@Qualifier("<some-value-1>")
public DataSource getNormalDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:PORT/DB_NAME");
        config.setUsername("USERNAME");
        config.setPassword("PASSWORD");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }



@Bean(name = "sessionFactory_origin")
@Qualifier("<some-value-2>")
public DataSource getSecondaryDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:PORT/DB_NAME");
        config.setUsername("USERNAME");
        config.setPassword("PASSWORD");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }