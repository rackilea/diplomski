@RunWith(SpringRunner.class) // required for all spring tests
@DataJpaTest(excludeAutoConfiguration = {TestDatabaseAutoConfiguration.class, DataSourceAutoConfiguration.class}) // this stops the default data source and database being configured.
@SqlConfig(dataSource = TestDataSourceConfig.SCHEMA_DATA_SOURCE, transactionManager = SCHEMA_TRANSACTION_MANAGER, transactionMode = SqlConfig.TransactionMode.ISOLATED) // make sure the @Sql statements are run using the SCHEMA datasource and txManager in an isolated way so as not to cause problems when running test methods requiring these statements to be run.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestDataSourceConfig.class})
@TestExecutionListeners({ 
    SqlScriptsTestExecutionListener.class, // enables the @Sql script annotations to work.
    SpringBootDependencyInjectionTestExecutionListener.class, // injects spring components into the test (i.e. the EntityManager)
    TransactionalTestExecutionListener.class}) // I have this here even though the @Transactional annotations don't exist yet as I plan on using them in further tests.
public class NotificationTypeEnumTest {

    @PersistenceContext(unitName = "pu") // required to inject the correct EntityManager
    private EntityManager em;

    // these statements are 
    @Test
    @Sql(statements = {"INSERT INTO MYAPP_ENUM (ENUM_ID, \"TYPE\", \"VALUE\") VALUES (MYAPP_ENUM_ID_SEQ.nextval, '" + NotificationTypeEnum.DTYPE + "', 'foo')"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = {"DELETE FROM MYAPP_ENUM"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void canFetchNotificationTypeEnum() throws Exception {
        TypedQuery<NotificationTypeEnum> query = em.createQuery("select a from NotificationTypeEnum a", NotificationTypeEnum.class); // notification type is just a subclass of the BaseEnum type
        NotificationTypeEnum result = query.getSingleResult();
        assertEquals("foo", result.getValue());
        assertEquals(NotificationTypeEnum.DTYPE, result.getConfigType());
    }
}