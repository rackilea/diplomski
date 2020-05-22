import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class insly_Privacy_Policy {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.get("https://signup.insly.com/signup");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("privacy policy"))).click();
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='document-content']//following::div[contains(.,'Revision')]"))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}