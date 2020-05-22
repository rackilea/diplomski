public class PersistenceTestHelper {

  private LocalServiceTestHelper appEngineHelper;

  @Before
  public void setUp() throws Exception {
    LocalDatastoreServiceTestConfig dsConfig = new LocalDatastoreServiceTestConfig();
    dsConfig.setNoIndexAutoGen(false);
    appEngineHelper = new LocalServiceTestHelper(dsConfig);
    appEngineHelper.setUp();
    ...
  }

  @After
  public void tearDown() throws Exception {
    // appEngineHelper.tearDown();
  }
}