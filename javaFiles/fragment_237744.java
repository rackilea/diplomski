public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider, Stoppable {

    @Override
    public Connection getAnyConnection() throws SQLException {
        return defaultDataSource.getConnection();
    }
    ...
}