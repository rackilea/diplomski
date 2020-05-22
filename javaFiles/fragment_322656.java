import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class EmployeeID {

    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\NotBackedUp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("Your site name");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(3, TimeUnit.MINUTES).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        WebElement username = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("txtUsername"));
            }
        });

        WebElement password = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("txtPassword"));
            }
        });

        WebElement submit = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("btnLogin"));
            }
        });

        // Enter your site user name
        username.sendKeys("Enter Username here");
        // Enter your site password
        password.sendKeys("Enter Password here");
        submit.click();

        WebElement pim = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("menu_pim_viewPimModule"));
            }
        });

        new Actions(driver).moveToElement(pim).build().perform();

        WebElement addEmployee = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("menu_pim_addEmployee"));
            }
        });

        addEmployee.click();

        WebElement firstName = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("firstName"));
            }
        });


        WebElement middleName = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("middleName"));
            }
        });


        WebElement lastName = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("lastName"));
            }
        });


        firstName.sendKeys("Arya");
        middleName.sendKeys("Stark");
        lastName.sendKeys("Starky");

        WebElement getEmployeeID = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("employeeId"));
            }
        });

        String employeeID = getEmployeeID.getAttribute("value");

        WebElement save = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("btnSave"));
            }
        });

        save.click();

        WebElement employeeList = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("menu_pim_viewEmployeeList"));
            }
        });

        employeeList.click();

        WebElement newlyCreatedEmployeeInTable  = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return  driver.findElement(By.xpath("//a[text()='"+employeeID+"']"));
            }
        });

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newlyCreatedEmployeeInTable);

        System.out.println(employeeID+" is in the Table ? "+newlyCreatedEmployeeInTable.getText().trim().equals(employeeID));
    }

}