public class LazyWebDriver implements WebDriver {
    private WebDriver driver;

    public LazyWebDriver(WebDriver driver, int secondsToWait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, secondsToWait);
    }

    public void close() {
        driver.close();
    }

    public WebElement findElement(By by) {
        return new LazyWebElement(driver, by, wait);
    }

    public List<WebElement> findElements(By by) {
        return new LazyWebElementList(driver, by, wait);
    }

    // ... other methods just call through to driver.foo(...)
}