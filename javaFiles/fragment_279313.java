public class A_Firefox_binary 
{
    public static void main(String[] args) 
    {
        System.setProperty("webdriver.gecko.driver", "C:/Utility/BrowserDrivers/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\path\\to\\firefox.exe");
        WebDriver driver =  new FirefoxDriver(options);
        driver.get("https://stackoverflow.com");
        System.out.println("Page Title is : "+driver.getTitle());
        driver.quit();
    }
}