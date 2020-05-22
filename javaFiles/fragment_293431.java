@Before
public void setUp() throws Exception {
    SystemProperty.version.set("JUnitVersion");
    SystemProperty.applicationId.set("JUnitApplicationId");
    SystemProperty.applicationVersion.set("JUnitApplicationVersion");
    SystemProperty.environment.set( SystemProperty.Environment.Value.Development );
    helper.setUp();
    datastore = DatastoreServiceFactory.getDatastoreService();
    queue = QueueFactory.getDefaultQueue();
}