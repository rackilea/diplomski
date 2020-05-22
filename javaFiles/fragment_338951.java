String browserType = "firefox"; // hardcoded for the example
WebDriver driver;

switch (browserType)
{
    case "firefox":
        driver = new FirefoxDriver();
        break;
    case "ie":
        driver = new InternetExplorerDriver();
        break;
    case "chrome":
        driver = new ChromeDriver();
        break;
    default:
        throw new Exception("browserType: " + browserType + " not defined.");
}

// do test case
driver.get("http://www.google.com");
// ... and so on