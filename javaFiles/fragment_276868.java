import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q44982690_ajax 
{

    static WebDriver driver=null;
    public static void main(String[] args) 
    {

        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.cathaypacific.com/cx/en_IN.html");
        WebElement leavingFrom=driver.findElement(By.xpath("//input[@id='depart-label']"));
        leavingFrom.click();
        leavingFrom.sendKeys("Bengaluru"); // Entering the starting point
        WebElement cityList=driver.findElement(By.xpath("//*[contains(@id,'ui-id')]//a"));
        System.out.println(cityList.getText());
        cityList.click();  // Selecting the required option
        WebElement goingTo=driver.findElement(By.xpath("//input[@id='destination-label']"));
        goingTo.click();
        goingTo.sendKeys("Singapore");  //Entering the Destination point 
        WebElement gCityList=driver.findElement(By.xpath("//input[@id='destination-label']//following::ul[1]/li/a")); //THIS IS WHERE XPATH IS AGAIN WORKING 
        System.out.println(gCityList.getText()); 
        gCityList.click();
    }
}