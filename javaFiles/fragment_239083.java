List<WebElement> linkElements = new ArrayList<WebElement>();
ListIterator<WebElement> itr = null;
System.setProperty("webdriver.chrome.driver",
    "webdrivers/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize(); // Maximize window
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://google.com");
WebElement element1 = driver.findElement(By.name("q"));
WebElement toClick = null;
element1.sendKeys(getText);
element1.submit();

// try{
int pageNumber = 1;
WebDriverWait wait = new WebDriverWait(driver, 10);
boolean flag = false;
while (!flag) {
    linkElements = wait.until(ExpectedConditions
        .presenceOfAllElementsLocatedBy(By
            .xpath("//h3[@class='r']/a")));
    itr = linkElements.listIterator(); // re-initializing iterator
    while (itr.hasNext()) {
        toClick = itr.next();
        if (toClick.getAttribute("href").contains(getSiteName)) {
            toClick.click();
            flag = true;
            break;
        }
    }
    if (!flag) {
        driver.findElement(By.xpath("//a[@id='pnnext']/span[1]"))
            .click();
        pageNumber++;
        linkElements.clear(); // clean list
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
            By.xpath("//td[@class='cur']"), pageNumber + ""));
    }
}
driver.quit(); // clear memory
}