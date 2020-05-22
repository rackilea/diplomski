public class Selenium implements WebDriver {
private static HashMap<Thread, WebDriver> webdriverPool = new HashMap<Thread, WebDriver>();
private WebDriver driver = null;

private Selenium(WebDriver driver) {
    this.driver = driver;
}

public static Selenium get() {
    WebDriver currentDriver = webdriverPool.get(Thread.currentThread());
    if (currentDriver != null) return new Selenium(currentDriver);
    else {
        //initialize WebDriver like this
        //add switches etc. Return an instance of our Custom class wrapping the WebDriver
        return new Selenium(new FirefoxDriver());
    }
}

@Override
public void close() {
    driver.close();
}

@Override
public WebElement findElement(By arg0) {
    handlePopUp();
    return driver.findElement(arg0);
}

@Override
public List<WebElement> findElements(By arg0) {
    handlePopUp();
    return driver.findElements(arg0);
}

@Override
public void get(String arg0) {
    driver.get(arg0);
    handlePopUp();
}

@Override
public String getCurrentUrl() {
    return driver.getCurrentUrl();
}

@Override
public String getPageSource() {
    return driver.getPageSource();
}

@Override
public String getTitle() {
    return driver.getTitle();
}

@Override
public String getWindowHandle() {
    return driver.getWindowHandle();
}

@Override
public Set<String> getWindowHandles() {
    return driver.getWindowHandles();
}

@Override
public Options manage() {
    return driver.manage();
}

@Override
public Navigation navigate() {
    return driver.navigate();
}

@Override
public void quit() {
    driver.quit();
}

@Override
public TargetLocator switchTo() {
    return driver.switchTo();
}

public void click(WebElement element) {
    handlePopUp();
    element.click();
}

public void click(By by) {
    handlePopUp();
    this.findElement(by).click();
}

public void sendKeys(WebElement element, String keys) {
    handlePopUp();
    element.sendKeys(keys);
}

public void sendKeys(By by, String keys) {
    handlePopUp();
    this.findElement(by).sendKeys(keys);
}

private void handlePopUp() {
    //your custom method
}