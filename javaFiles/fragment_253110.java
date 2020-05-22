public abstract class BaseDAOTest extends UnitilsJUnit4 {

    @TestDataSource
    private DataSource dataSource;

    @Before    
    public void initializeDao() {
        BaseDAO dao = getDaoUnderTest();
        dao.setDataSource(dataSource);
    }

    protected abstract BaseDAO getDaoUnderTest();
}