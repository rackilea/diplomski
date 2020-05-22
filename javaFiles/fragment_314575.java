package keya;    
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.By;

public class Common {
    protected static WebDriver driver;

    public Common(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}