public class LocalDriverFactory {

    public static WebDriver createInstance(String browserName, Boolean isHeadless) throws IOException {

        WebDriver driver = null;
        if (browserName.toLowerCase().contains("firefox")) {

        }
        if (browserName.toLowerCase().contains("internet")) {
            /*driver = new InternetExplorerDriver();
            return driver;*/
        }
        if (browserName.toLowerCase().contains("chrome")) {
            ChromeDriverFactory cFac = new ChromeDriverFactory(isHeadless);
            driver = cFac.driver.get();
        }
        if (browserName.toLowerCase().trim().equals("safari"))
        {
           /* driver = SafariDriverFactory.driver.get();
            LocalDriverManager.setFFWebDriver(driver);*/
        }
        if (browserName.toLowerCase().trim().contains("phantom"))
        {
            java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        }
        return driver;
    }
}