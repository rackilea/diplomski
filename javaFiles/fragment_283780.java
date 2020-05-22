package AddUser;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class CheckFirstname 
    {
    public static WebDriver d;
        public static void main(String []args)throws Exception{
           System.setProperty("webdriver.firefox.marionette","pathToGeckodriver");
           FirefoxDriver driver=new FirefoxDriver();


           driver.get("http://54.68.159.204/qmsadm");
           driver.manage().window().maximize();
           WebElement element=driver.findElement(By.name("username"));
           element.sendKeys("geosony");
           element=driver.findElement(By.name("password"));
           element.sendKeys("1");
           element.submit();
           element=driver.findElement(By.linkText("Admin"));
           element.click();
           element=driver.findElement(By.linkText("Users"));
           element.click();
           element=driver.findElement(By.xpath("//*[@id='search-container']/a/i"));
           element.click();




           element= driver.findElement(By.id("username"));
           element.sendKeys("#!#!#$@#!$@!$@#$%#%^#$^^&%&$%*");

           driver.findElement(By.xpath("//*[@id='adduser']/div/form/div[2]/div/div/label")).click();
           Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 30 );

            wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        alert.accept();






        }   
    }