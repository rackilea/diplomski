public class HttpUnitTest extends HttpUserAgentTest {

    @Before
    /**
     * setup the test by resetting the environment for Http Unit tests
     */
    public void setUpHttpUnitTest() throws Exception {
        HttpUnitOptions.reset();
        HTMLParserFactory.reset();
    }