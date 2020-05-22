@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DbUnitConfiguration(dataSetLoader = ColumnSensingFlatXMLDataSetLoader.class)
public class TemplateIT {

    @Before
    public void after() throws Exception {
        IDatabaseConnection connection;
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL + "&sessionVariables=FOREIGN_KEY_CHECKS=0", USER, JDBC_PASSWORD);
        connection = databaseTester.getConnection();
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        DatabaseOperation.DELETE_ALL.execute(connection,
                partialDataSet);
    }


    @DatabaseSetup("../dbunit/data.xml")
    @ExpectedDatabase("../dbunit/expected.xml")
    @Test
    public void testDBUnit() throws Exception {
        ...
    }


}