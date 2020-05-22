import org.apache.tapestry5.test.PageTester;

public class LoadTest {
    private final String PAGE_NAME = "Login"; // It has to be right too!
    private final String APP_NAME = "app"; // Where was your app name?
    private final String context = "src/main/webapp"; // Is that path right in your project?
    private PageTester tester;

    @Before
    public void init() {
        String appPackage = "hu.webapp"; // Check if that's really correct!!!
        tester = new PageTester(appPackage, APP_NAME, context);
    }

    @Test
    public void confirmIndexIsLoaded() {
        Document document = tester.renderPage(PAGE_NAME);
        assertNotNull(document);
    }
}