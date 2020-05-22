public class LazyWebElement implements WebElement {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By by;
    private WebElement element;

    public LazyWebElement(WebDriver driver, By by, WebDriverWait wait) {
        this.driver = driver;
        this.by = by;
        this.wait = wait;
    }

    private WebElement getElement() {
        if (element == null) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element = driver.findElement(by);
        }

        return element;
    }

    public void clear() {
        getElement().clear();
    }

    public void click() {
        getElement().click();
    }

    public String getAttribute(String attributeName) {
        return getElement().getAttribute(attributeName);
    }

    // Other methods in WebElement interface must first call getElement()
}