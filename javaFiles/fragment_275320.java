public class BlobstoreDaoTest {
    private LocalServiceTestHelper helper =
            new LocalServiceTestHelper(
              new LocalDatastoreServiceTestConfig(),
              new LocalBlobstoreServiceTestConfig()
            );

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }
...