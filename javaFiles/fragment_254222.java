public class BooksEndpointTest {

    private final LocalServiceTestHelper testHelper = new LocalServiceTestHelper(
            new LocalDatastoreServiceTestConfig()
    );

    private Closeable objectifyService;

    @Before
    public void setUp() throws Exception {
        testHelper.setUp();
        objectifyService = ObjectifyService.begin(); // required if you want to use Objectify
    }

    @After
    public void tearDown() throws Exception {
        testHelper.tearDown();
        objectifyService.close();
    }

    @Test
    public void testSaveBook() throws Exception {
        // Create Endpoint and execute your method
        new BooksEndpoint().saveBook(
                Book.create("id", "name", "author"),
                new User("example@example.com", "authDomain")
        );

        // Check what was written into datastore
        BookRecord bookRecord = ofy().load().type(BookRecord.class).first().now();

        // Assert that it is correct (simplified)
        assertEquals("name", bookRecord.getName());
    }

}