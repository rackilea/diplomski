public class TNGDriver {

public static WebDriver driver;
private static String chromeDriverPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";  

public void DriverConfiguration() {        
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");  
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);        
    driver = new ChromeDriver(capabilities);    
    driver.manage().window().maximize();            
}

public void QuitDriver(){
    driver.quit();
}

}