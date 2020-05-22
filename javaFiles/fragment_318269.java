package 123;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import parametrii.Utilitara;

public class CompletareFlexi {
    private WebDriver driver;

    //FindBy
    @FindBy(css="input[type='text'][name='price2']")  
    WebElement price2two;

    public CompletareFlexi(WebDriver driver) {
        this.driver = driver
    }

    public TestFormular  completareFlexiCampuri() throws Throwable{
        Utilitara util = new Utilitara(driver);
        TestFormular TestFormular = new TestFormular(driver);
        TestFormular.testFormular();
        price2two.sendKeys(Utilitara.randomNumar(5));

        //driver.findElement(By.cssSelector("input[type='text'][name='xxxxx']")).sendKeys(Utilitara.randomNumar(5));
        return PageFactory.initElements(driver, TestFormular.class);
    }
}