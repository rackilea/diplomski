import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class SeleniumTests {


    @Test()
    public void testmethod() throws  Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.findElement(By.className("something")); // throws NoSuchElementException
        Assert.assertEquals(true, false);
        driver.quit();
    }

}