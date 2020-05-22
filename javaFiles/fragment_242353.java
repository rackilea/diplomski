public class CollectUrls {

private WebDriver driver;

public CollectUrls() {
    this.driver = new FirefoxDriver();
    this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

protected void next(String url, List<String> argUrlsList) {
    this.driver.get(url);
    String htmlContent = this.driver.getPageSource();
}