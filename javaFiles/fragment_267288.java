public class EditPost {

    WebDriver driver;

    By messageLocator = By.cssSelector("#message > p")

    public EditPost(WebDriver editPostDriver)
    {
        this.driver = editPostDriver;
    }

    public String getMessage()
    {
        return driver.findElement(messageLocator).getText();
    }
}