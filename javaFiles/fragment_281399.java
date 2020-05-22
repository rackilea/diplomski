protected static WebDriver Browser_Session;

@BeforeSuite
public void beforeSuite() {
    Browser_Session=new FirefoxDriver();
    Browser_Session.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
}

@AfterSuite
public void afterSuite() {
    Browser_Session.quit();
}