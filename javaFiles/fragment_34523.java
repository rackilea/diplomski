import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListTest {

static WebDriver driver;

public static void main(String[] args) {
    List<String> submenu = new ArrayList<>(Arrays.asList(new String[]{"See all current accounts", "1|2|3 Current Account", "Everyday Current Account", "Basic Current Account", "Choice Current Account"}));
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("http://www.santander.co.uk/uk/index");
    for (String sMenu : submenu) {
        WebElement a = driver.findElement(By.cssSelector("#nav > div.navMain > div.nav_menu > nav > ul > li:nth-child(1) > a"));
        new Actions(driver).moveToElement(a).build().perform();
        clickAnElementByLinkText("//li[@role='listitem']/a[normalize-space(text())='" + sMenu + "']");
        driver.navigate().back();
    }
    driver.quit();
}

public static void clickAnElementByLinkText(String linkText) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkText))).click();
}
}