public class Helper {

public static void scrollToElementAndClick(WebDriver driver, WebElement webelement){
Actions actions = new Actions(driver);
actions.moveToElement(webelement).click();

action = action.build;
action.perform();

}