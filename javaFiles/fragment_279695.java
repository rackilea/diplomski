public class UserSchemaAwareRoutingDataSource extends AbstractDataSource {
    private @Inject javax.inject.Provider<User> user;
    private @Inject Environment env;
    private LoadingCache<String, DataSource> dataSources = createCache();

    @Override
    public Connection getConnection() throws SQLException {
        return determineTargetDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return determineTargetDataSource().getConnection(username, password);
    }

    private DataSource determineTargetDataSource() {
        String schema = user.get().getSchema();
        return dataSources.get(schema);
    }

    private LoadingCache<String, DataSource> createCache() {
        return CacheBuilder.newBuilder()
           .maximumSize(100)
           .expireAfterWrite(10, TimeUnit.MINUTES)
           .build(
               new CacheLoader<String, DataSource>() {
                 public DataSource load(String key) throws AnyException {
                   return buildDataSourceForSchema(key);
                 }
               });
    }

    private DataSource buildDataSourceForSchema(String schema) {
        // e.g. of property: "jdbc:postgresql://localhost:5432/mydatabase?currentSchema="
        String url = env.getRequiredProperty("spring.datasource.url") + schema;
        return DataSourceBuilder.create()
            .driverClassName(env.getRequiredProperty("spring.datasource.driverClassName"))
            [...]
            .url(url)
            .build();
    }
}