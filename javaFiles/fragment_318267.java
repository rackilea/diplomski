package 123;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestLogIn {
    private WebDriver driver;

    public TestLogIn(WebDriver driver) {
        this.driver = driver;
    }


    //@Test
    public void logareXXX() {
        driver.findElement(By.cssSelector("form input[type='text'][name='username']")).sendKeys("XX");
        driver.findElement(By.cssSelector("form input[name='password']")).sendKeys("XX");
        driver.findElement(By.cssSelector("form input[name='submit']")).click()
        //Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "xxx");
        //driver.findElement(By.cssSelector("[href='logoff.do']")).click();
        //driver.findElement(By.cssSelector("#info")).getText();
        //System.out.println();
        //Assert.assertEquals("Informatii generale", driver); ("announcement")
    }
}