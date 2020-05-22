package keya;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Module3 extends Common{

    public static void main(String...strings) throws Exception{
        Common c = new Common();
        driver.get("webAddress");
        driver.findElement(By.xpath("//*[@id='Username']")).sendKeys("A1");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id='loginBox']/form/p/button")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//*[@id='mainNav']/li[2]/a")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//*[@id='addNewEntryButton']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='timeEntryTable']/tbody/tr[1]/td[1]/select"));
        List<WebElement> dropOptions = dropdown.findElements(By.tagName("Option"));
        for (int i=0; i<dropOptions.size(); i++)
        {
         System.out.println(dropOptions.get(i).getText());
        }
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//*[@id='timeEntryTable']/tbody/tr[1]/td[1]/select")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@id='timeEntryTable']/tbody/tr[1]/td[5]/input")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='timeEntryTable']/tbody/tr[1]/td[6]/input")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='saveEntryButton']")).click();
        Thread.sleep(5000L);
        driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div/div[3]/div/header/div/button[4]")).click();
        //Here is the verification whether Submit button is present or not
        c.isElementPresent(By.xpath("//button[contains(.,'submit')]"));
        //Rest of the code is here
    }
}