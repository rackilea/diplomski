package 123;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestFormular{
    private WebDriver driver;       

    public TestFormular(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public CompletareFlexi testFormular() throws Throwable { 
        TestLogIn TestLogIn = new TestLogIn(driver);
        TestLogIn.logareXX();

        //driver.findElement(By.linkText("xxxx")).click();
        //adaugarePresocring.click();

        Select Produs = new Select(driver.findElement(By.className("valid")));
        Produs.selectByIndex(2);                
        driver.findElement(By.cssSelector(".submitButton")).click();

        driver.findElement(By.cssSelector("form input[name='xxxx']")).sendKeys("xxxx");
        driver.findElement(By.cssSelector("form input[type='button'][onclick='xxxx()']")).click();
        //Alert alert =
                driver.switchTo().alert().accept();;
        //System.out.println(alert.getText());
        //alert.accept();

        driver.findElement(By.cssSelector("form input[type='button'][onclick='xxx();']")).click();

        PrintareProblem thr = new PrintareProblem( "PrintareProblem", 5000);
        driver.findElement(By.cssSelector(".button")).click();

        return PageFactory.initElements(driver, CompletareFlexi.class);
    }
}