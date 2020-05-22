@Test
public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.lexisnexis.com/hottopics/lnacademic/?verb=sf&sfi=AC00NBGenSrch"); 
        driver.switchTo().frame("mainFrame");

        WebDriverWait waitst = new WebDriverWait(driver, 0);
        waitst.until(ExpectedConditions.visibilityOfElementLocated(By.name("sourceTitle")));

        WebElement sourceTitle = driver.findElement(By.name("sourceTitle"));
        sourceTitle.sendKeys("Times"); 
        Thread.sleep(5000);
        WebElement firstItem = driver.findElement(By.xpath("//*[@class='auto_suggest']/*[@class='title_item']"));
        firstItem.click();
}