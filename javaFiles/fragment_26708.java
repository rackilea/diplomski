private static Map<String, ComboPooledDataSource> dataSources;

static {
    dataSources = new Map<String, ComboPooledDataSource>();
}

public static void createDataSource(String dbName) {
    ComboPooledDataSource pooledDataSource =  new ComboPooledDataSource();
    if(dbName.equals("DB_ONE")) {
        // Here passing parameters will be different for DB_ONE              
        pooledDataSource.setDriverClass(dbDriver);
        pooledDataSource.setJdbcUrl(dbUrl);
        pooledDataSource.setUser(userID);
        pooledDataSource.setPassword(password);
        pooledDataSource.setMinPoolSize(Integer.parseInt(minCon));
        pooledDataSource.setMaxPoolSize(Integer.parseInt(maxCon));
        pooledDataSource.setMaxIdleTime(Integer.parseInt(maxIdleTime));
        pooledDataSource.setInitialPoolSize(Integer.parseInt(intialPoolSize));
        pooledDataSource.setPreferredTestQuery(testQuery);
        dataSources.put(dbName, pooledDataSource);
    } else if(dbName.equals("DB_TWO")) {
        // Here passing parameters will be different for DB_TWO              
        pooledDataSource.setDriverClass(dbDriver);
        pooledDataSource.setJdbcUrl(dbUrl);
        pooledDataSource.setUser(userID);
        pooledDataSource.setPassword(password);
        pooledDataSource.setMinPoolSize(Integer.parseInt(minCon));
        pooledDataSource.setMaxPoolSize(Integer.parseInt(maxCon));
        pooledDataSource.setMaxIdleTime(Integer.parseInt(maxIdleTime));
        pooledDataSource.setInitialPoolSize(Integer.parseInt(intialPoolSize));
        pooledDataSource.setPreferredTestQuery(testQuery);
        dataSources.put(dbName, pooledDataSource);
    }
}

public synchronized Connection getConnection(String dbName) {
    if (!dataSources.containsKey(dbName)) {
        createDataSource(dbName);
    }
    return  dataSources.get(dbName).getConnection();
}