public static void main(String[] args) {

    WebDriver driver = new FirefoxDriver();
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Cheese!\n"); // send also a "\n"
    element.submit();

    // wait until the google page shows the result
    WebElement myDynamicElement = (new WebDriverWait(driver, 10))
              .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

    List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

    // this are all the links you like to visit
    for (WebElement webElement : findElements)
    {
        System.out.println(webElement.getAttribute("href"));
    }
}