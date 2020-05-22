public class BackedWebdriver {

    public static WebDriver driver;
    public static String baseUrl;
    public static Selenium selenium;

    public static void main(String[] args) {
        driver = new FirefoxDriver();    //Here we are mentioning that we will use Firefox browser
        baseUrl = "http://www.google.co.in/";
        driver.get(baseUrl);
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
        selenium.windowMaximize();
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("selenium");
        selenium.click("g");
        driver.findElement(By.id("gbqfb")).click();


    }