public class FooTest {

    private DriverDelegate driver;

    @BeforeMethod
    public void setup() {
        try {
            driver = new DriverDelegate("url");
        } catch (Exception ignore) { }
    }

    @AfterMethod
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception ignore) { }
        driver = null;
    }

    @Test
    public void foo() {
        // do test stuff
    }
}