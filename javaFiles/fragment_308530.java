driver.get(
        "https://www.flipkart.com/search?q=iphone&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_0_4&otracker1=AS_QueryStore_OrganicAutoSuggest_0_4&as-pos=0&as-type=RECENT&as-backfill=on");

By firstSearchResult = By.className("_3O0U0u");
driver.findElement(firstSearchResult).click();

Thread.sleep(1000);

String currentWindow = driver.getWindowHandle();
Set<String> windows = driver.getWindowHandles();
for (String window : windows) {
    if (!window.equals(currentWindow)) {
        driver.switchTo().window(window);
    }
}

// I'm performing these three steps to set pin-code, as i'm not logging-in. You
// may not have to perform these three steps as you are already logged -in.
driver.findElement(By.id("pincodeInputId")).clear();
driver.findElement(By.id("pincodeInputId")).sendKeys("500081");
driver.findElement(By.xpath("//*[@class='_2aK_gu' and text()[contains(.,'Check')]]")).click();


By button = By.xpath("//button[text()[contains(.,'BUY NOW')]]");
WebDriverWait wait = new WebDriverWait(driver, 15);
wait.until(ExpectedConditions.elementToBeClickable(button));
driver.findElement(button).click();