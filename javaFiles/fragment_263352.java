import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

//Initiate WebDriver
System.setProperty("webdriver.chrome.driver", "<absolute path of chromedriver>");
log.info(System.getProperty("webdriver.chrome.driver"));

WebDriver driver=new ChromeDriver()


//Setup Environment
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
driver.get("http://www.google.com");

//Your Code
Thread.sleep(10000)
driver.quit()