@BeforeTest
@Parameters("browserType")
public void setUp(String browserType) throws InterruptedException  {
    rp = new RegistrationPage();

    Configuration.baseUrl = "http://demoqa.com/registration/";

    if (browserType.equalsIgnoreCase("firefox")) {
        WebDriverRunner.setWebDriver(new FirefoxDriver());
    } else if (browserType.equalsIgnoreCase("chrome")){
        WebDriverRunner.setWebDriver(new ChromeDriver());
    }

}