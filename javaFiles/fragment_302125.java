package brucey;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverBase extends WebDriverSetup {

    @BeforeClass public static void setUpClass() {
        startFF();
    }

    @Before public void setUp() {}

    @After public void tearDown() {}

    @AfterClass public static void tearDownClass() {
        shutdownFF();
    }

    public WebDriverWait waitSec(WebDriver driver, int sec) {
        return new WebDriverWait(driver, sec);
    } 

    public WebElement byId(String id) {
        WebElement element = driver.findElement(By.id(id));
        return element;
    }   

    public WebElement byXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    } 

    public WebElement byText(String text) {
        WebElement element = driver.findElement(By.linkText(text));
        return element;
    }   

    public WebElement clickableByXpath(String xpath, int sec) {
           WebElement element = waitSec(driver, sec).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
           return element;
    }  

    public WebElement clickableByName(String name, int sec) {
           WebElement element = waitSec(driver, sec).until(ExpectedConditions.elementToBeClickable(By.name(name)));
           return element;
    }    

    public WebElement visibleByXpath(String xpath, int sec) {
           WebElement element = waitSec(driver, sec).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
           return element;
    }   

    public WebElement visibleById(String id, int sec) {
       WebElement element = waitSec(driver, sec).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
       return element;
    }   

    public List<WebElement> byXpaths(String xpath) {
           List<WebElement> elements = driver.findElements(By.xpath(xpath));
           return elements;
    }   

    public void atr2beByXpath(int sec, String xpath, String atr, String val) {
        waitSec(driver, sec).until(ExpectedConditions.attributeToBe(By.xpath(xpath), atr, val));    
    }

    public void atrNot2beByXpath(int sec, String xpath, String atr, String val) {
        waitSec(driver, sec).until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(xpath), atr, val)));
    }

    public void elements2beMoreByXpath(String xpath, int sec, int amount) {
        waitSec(driver, sec).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), amount));
    }

    public void elements2beByXpath(String xpath, int sec, int amount) {
        waitSec(driver, sec).until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), amount));
    }

    public void tryUrl2be(int sec, String url) {
        try {waitSec(driver, sec).until(ExpectedConditions.urlToBe(url));
      } catch (TimeoutException e) {}
    }
    public void tryUrl2contain(int sec, String string) {
        try {waitSec(driver, sec).until(ExpectedConditions.urlContains(string));
      } catch (TimeoutException e) {}
    }
}