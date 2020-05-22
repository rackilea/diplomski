public class LoginPage {
    private final WebDriver driver;

    private final String emailField = "#email";
    private final String passwordField = "#password";
    private final String submitButton = "#submit";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // These are our bite sized methods right here
    public LoginPage enterEmail(String email) {
        driver.findElement(By.cssSelector(emailField)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(By.cssSelector(passwordField)).sendKeys(password);
        return this;
    }

    public void submit() {
        driver.findElement(By.cssSelector(submitButton)).click();
    }

    // This method represents an entire workflow, 
    // containing multiple bite-sized chunks.
    public void performLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        submit();
    }
}