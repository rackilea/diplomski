public class BrowserFactory {

public static WebDriver localDriver(Capabilities capabilities) {
String browserType = capabilities.getBrowserName();
if (browserType.equals("firefox"))
  return new FirefoxDriver(capabilities);
if (browserType.startsWith("internet explorer"))
  return new InternetExplorerDriver(capabilities);
if (browserType.equals("chrome"))
  return new ChromeDriver(capabilities);
throw new Error("Unrecognized browser type: " + browserType);
}