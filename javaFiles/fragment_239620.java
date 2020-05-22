@RunWith(Suite.class)
@SuiteClasses({ Test1.class, Test2.class})
public class MyTestSuite {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        driver = new RemoteWebDriver(new URL(hubAddress), capability);
    }

    @AfterClass
    public static void setDownClass() {
         driver.quit();
    }
}