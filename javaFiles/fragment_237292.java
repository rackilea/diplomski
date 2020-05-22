WebDriver driver = new ChromeDriver();
int secondsToWait = 15;
WebDriver lazyDriver = new LazyWebDriver(driver, secondsToWait);

// findElement(...) returns immediately
WebElement element = lazyDriver.findElement(By.id("foo"));

// Implicitly waits up to 15 seconds for the element
// to become visible before attempting to click on it
element.click();

// Returns immediately since the "wrapped" element
// has already been fetched after waiting.
String name = element.getAttribute("name");