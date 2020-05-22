WebDriver driver = new FirefoxDriver();
driver.get("http://curatorsofsweden.com/archive/");

By linkSelector = By.cssSelector("div[class='block block--archive'] a");

WebDriverWait wait = new WebDriverWait(driver, 2);
wait.until(ExpectedConditions.presenceOfElementLocated(linkSelector));

List<WebElement> linkElements = driver.findElements(linkSelector);
for (WebElement linkElement : linkElements) {
    String link = linkElement.getAttribute("href");
    System.out.println("LINK " + link);
}
driver.quit();