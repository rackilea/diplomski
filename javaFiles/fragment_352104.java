package myproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class mouseOverEvent {
    WebDriver driver=new FirefoxDriver();
    public static void main(String[] args){
        driver.get("http://www.google.co.in");
        Actions Builder=new Actions(driver);
        WebElement home=driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[2]"));
        Action mouseOverHome= Builder.moveToElement(home).click().build();
        mouseOverHome.perform();
    }
}