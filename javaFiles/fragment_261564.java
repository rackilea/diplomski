public class ChromeTestManager {

        private WebDriverManager webDriverManager = new WebDriverManager();
        private WebDriver driver;

        private LoginPages loginPages;
        private AdminPages adminPages;

        private static ITestContext context;  // creating a ITestContext variable

        @BeforeClass
        //@Parameters({"browser"})
        public void setupTest(ITestContext iTestContext) throws MalformedURLException {
            System.out.println("BeforeMethod is started. " + Thread.currentThread().getId());
            // Set & Get ThreadLocal Driver with Browser

            webDriverManager.createDriver("chrome");
            driver = webDriverManager.getDriver(); 

            this.context = setContext(iTestContext, driver);  // setting the driver into context

            // Pages Object Initialization
            loginPages = PageFactory.initElements(driver, LoginPages.class);
            logoutPages = PageFactory.initElements(driver, LogoutPages.class);
            adminPages = PageFactory.initElements(driver, AdminPages.class);
        }