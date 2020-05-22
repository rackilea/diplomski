public class GitHubTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getInstance();
        driver.get("https://github.com/codesolid");
    }

    @Test
    public void testFirst() throws Exception {
        driver.findElement(By.linkText("tutorials")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.col-11"))));

        // validate if correct page is open by title & url      
        assertEquals(driver.findElement(By.xpath("//title")).getText(), "GitHub - CodeSolid/tutorials: Tutorials");
        assertEquals(driver.getCurrentUrl(), "https://github.com/CodeSolid/tutorials");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        DriverManager.closeQuietly();
    }
}

public class DriverManager {
    private static volatile WebDriver driverInstance;

    private DriverManager() {
    }

    public static synchronized WebDriver getInstance() {
        if (driverInstance == null) {
            switch (readBrowserType()) {
                case Firefox: {
                    driverInstance = new FirefoxDriver();
                    driverInstance.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    driverInstance.manage().window().maximize();
                    return driverInstance;
                }