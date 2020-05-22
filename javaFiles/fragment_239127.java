@BeforeTest
@Parameters({"browser", "baseURL"})
public void setUp(@Optional String browser, @Optional String baseURL) {
    driver = getBrowserType(browser);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.navigate().to(baseURL);
}