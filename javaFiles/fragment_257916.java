public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        WebElement usernameField = driver.findElementBy...;
        usernameField.sendKeys(username);
        return this; // returns this instance because it stays on the LoginPage
    }

    public LoginPage enterPassword (String password) {
        WebElement passwordField = driver.findElementBy...;
        passwordField.sendKeys(password);
        return this; // returns this instance because it stays on the LoginPage
    }
}