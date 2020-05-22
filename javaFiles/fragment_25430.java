public abstract class MyBatisTestBase {
    public abstract SqlSessionManager getSessionManager();

    @BeforeMethod
    public void beforeMethod() {
        getSessionManager().startManagedSession();
    }

    @AfterMethod
    public void afterMethod() {
        getSessionManager().rollback();
    }

    @DataProvider(name = "sql-session-manager-provider")
    public static Object[][] sqlSessionManagerProvider() throws SQLException, LiquibaseUpdateException {
        return new Object[][] {
                {createDerbySessionManager()},
                {createH2SessionManager()}
        };
    }

    private static SqlSessionManager createDerbySessionManager() throws SQLException, LiquibaseUpdateException {
        EmbeddedDataSource40 dataSource = new EmbeddedDataSource40();
        dataSource.setDatabaseName("memory:test-db");
        dataSource.setCreateDatabase("create");

        LiquibaseUtils.update(dataSource.getConnection(), LiquibaseUtils.DEFAULT_CONTEXTS);
        return MyBatisUtils.createSqlSessionManager(dataSource);
    }

    private static SqlSessionManager createH2SessionManager() throws SQLException, LiquibaseUpdateException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test-db;DB_CLOSE_DELAY=-1");

        LiquibaseUtils.update(dataSource.getConnection(), LiquibaseUtils.DEFAULT_CONTEXTS);
        return MyBatisUtils.createSqlSessionManager(dataSource);
    }
}