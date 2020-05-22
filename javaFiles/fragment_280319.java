import org.openqa.selenium.support.ui.WebDriverWait

public void clickAnElementByLinkText(String linkText) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
    driver.findElement(By.linkText(linkText)).click();
}