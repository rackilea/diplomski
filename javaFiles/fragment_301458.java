@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    // Create an instance of what you are going to test.
    // When using the @InjectMocks annotation, you must create the instance in
    // the constructor or in the field declaration.
    @InjectMocks
    private RegistrationController controllerUT = new RegistrationController();

    // The @Mock annotation creates the mock instance of the class and
    // automatically injects into the object annotated with @InjectMocks (if
    // possible).
    @Mock
    private RegistrationService registrationService;
    // This @Mock annotation simply creates a mock instance. There is nowhere to
    // inject it. Depending on the particular circumstance, it may be better or
    // clearer to instantiate the mock explicitly in the test itself, but we're
    // doing it here for illustration. Also, I don't know what your real class
    // is like, but it may be more appropriate to just instantiate a real one
    // than a mock one.
    @Mock
    private ModelMap model;
    // Same as above
    @Mock
    private BulkRegistration bulkRegistration;
    // Same as above
    @Mock
    private FileData fileData;

    @Before
    public void setUp() {
        // We want to make sure that when we call getFileData(), it returns
        // something non-null, so we return the mock of fileData.
        when(bulkRegistration.getFileData()).thenReturn(fileData);
    }

    /**
     * This test very narrowly tests the correct next page. That is why there is
     * so little expectation setting on the mocks. If you want to test other
     * things, such as behavior when you get an exception or having the expected
     * filename, you would write other tests.
     */
    @Test
    public void testCreate() throws Exception {
        final String target = "bulkRegistration";
        // Here we create a default instance of BindingResult. You don't need to
        // mock everything.
        BindingResult result = new BindingResult();

        String nextPage = null;
        // Perform the action
        nextPage = controllerUT.create(bulkRegistration, result, model);
        // Assert the result. This test fails, but it's for the right reason -
        // you expect "bulkRegistration", but you get "registration".
        assertEquals("Controller is not requesting the correct form", nextPage,
                target);

    }

    /**
     * Here is a simple example to simulate an exception being thrown by one of
     * the collaborators.
     * 
     * @throws Exception
     */
    @Test(expected = NumberFormatException.class)
    public void testCreateWithNumberFormatException() throws Exception {
        doThrow(new NumberFormatException()).when(registrationService)
                .processFile(any(File.class), anyList());
        BindingResult result = new BindingResult();
        // Perform the action
        controllerUT.create(bulkRegistration, result, model);
    }
}