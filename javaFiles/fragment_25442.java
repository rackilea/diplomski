import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//other lines of code
Actions mouseHover = new Actions(driver);
mouseHover.moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ParentElement)))).perform();
new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(subElement))).click();