package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {

    private static WebElement element = null;
    public static WebElement SignIn_click(WebDriver driver) throws InterruptedException {
    element = driver.findElement(By.xpath("id('J_SC_header')/header/div[2]//span[1]/a[@data-val='ma_signin']"));

    while (!isDisplayed(element)) 
    {
        Thread.sleep(3000);
        System.out.println("Element is not visible yet");
    }
    return element;

    }
    public static boolean isDisplayed(WebElement element) {
        try {
            if(element.isDisplayed())
                return element.isDisplayed();
            }catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }
}