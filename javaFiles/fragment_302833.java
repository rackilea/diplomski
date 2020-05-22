public class BaseTest{
    static WebDriver driver;
    @BeforeSuite
    public void start() {
        driver = new FFDriver();
        driver.get(url);
    }


    @AfterSuite
    public void end() {
        driver.close();
        driver.quit();
    }
}