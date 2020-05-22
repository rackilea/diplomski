public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
    ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
    test(driver, "Pelguranna 9");
}

public static void test(WebDriver driver, String query) throws InterruptedException {
    driver.get("https://www.omniva.ee/eng");

    Thread.sleep(5000);

    WebElement tab = driver.findElement(By.xpath("//a[.='Find a ZIP code'][@href='#search-zip']"));
    tab.click();

    WebElement name = driver.findElement(By.name("zip_address"));
    name.sendKeys(query);
    name.submit();

    Thread.sleep(10000);

    WebElement result = driver.findElement(By.xpath("//*[@id='zip_container']/p/span"));
    System.out.println(result.getText());
}