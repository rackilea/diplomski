public class LazyWebElementList implements List<WebElement> {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By by;
    private List<WebElement> elements;

    public LazyWebElementList(WebDriver driver, By by, WebDriverWait wait) {
        this.driver = driver;
        this.by = by;
        this.wait = wait;
    }

    private List<WebElement> getElements() {
        if (elements == null) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocated(by));
            elements = driver.findElements(by);
        }

        return elements;
    }

    public boolean add(WebElement element) {
        getElements().add(element);
    }

    public void clear() {
        getElements().clear();
    }

    // Other methods defined in List<E> interface must call getElements() first
}