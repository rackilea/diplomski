@Component
public class TenantRoutingDataSource extends AbstractDataSource implements InitializingBean
{

    @Override
    public Connection getConnection() throws SQLException
    {
        return determineTargetDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException
    {
        return determineTargetDataSource().getConnection(username, password);
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
    }

    protected String determineCurrentLookupKey()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String database = "shared";
        if (authentication != null && authentication.getPrincipal() instanceof MyUser)
        {
            MyUser user = (MyUser) authentication.getPrincipal();
            database = user.getTenantId();
        }
        String temporaryOverride = MultitenancyTemporaryOverride.tenantOverride.get();
        if (temporaryOverride != null)
        {
            database = temporaryOverride;
        }
        return database;
    }

    protected DataSource determineTargetDataSource()
    {
        return selectDataSource(determineCurrentLookupKey());
    }

    public DataSource selectDataSource(String tenantIdentifier)
    {
        //I use C3P0 for my connection pool
        PooledDataSource pds = C3P0Registry.pooledDataSourceByName(tenantIdentifier);
        if (pds == null)
            pds = getComboPooledDataSource(tenantIdentifier);
        return pds;
    }

    private ComboPooledDataSource getComboPooledDataSource(String tenantIdentifier)
    {
        ComboPooledDataSource cpds = new ComboPooledDataSource(tenantIdentifier);
        cpds.setJdbcUrl("A JDBC STRING HERE");
        cpds.setUser("MyDbUsername");
        cpds.setPassword("MyDbPassword");
        cpds.setInitialPoolSize(10);
        cpds.setMaxConnectionAge(10000);
        try
        {
            cpds.setDriverClass("com.informix.jdbc.IfxDriver");
        }
        catch (PropertyVetoException e)
        {
            throw new RuntimeException("Weird error when setting the driver class", e);
        }
        return cpds;
    }
}