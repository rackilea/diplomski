package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserType {

    @Test
    public static WebDriver Execute(String browser) {

         // Set Browsers
         WebDriver driver = null;
         if(browser.equalsIgnoreCase("firefox")) {
         driver = new FirefoxDriver();
         }

         else if (browser.equalsIgnoreCase("chrome")) { 

         {System.setProperty("webdriver.chrome.driver","C:/Users/elsid/Desktop/Eclipse/Selenium/chromedriver.exe");}
          driver = new ChromeDriver();        
          }

         else if (browser.equalsIgnoreCase("ie")) { 

              {System.setProperty("webdriver.ie.driver","C:/Users/elsid/Desktop/Eclipse/Selenium/IEDriverServer.exe");}
              driver = new InternetExplorerDriver(); 
              {DesiredCapabilities iecapabilities = DesiredCapabilities.internetExplorer();
              iecapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);}
              }

          // Implicit Wait and Maximize browser
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.manage().window().maximize();

          // Navigate to URL
          driver.get(Constant.URL);

          return driver;

    }