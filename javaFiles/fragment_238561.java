public class Firefox {

    static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    static final String FIREFOX_DRIVER_PATH = "...path/geckodriver.exe";

    WebDriver driver;

    public Firefox(){
        System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);
        driver = new FirefoxDriver();
    }


}