String parentHandle = browser.getWindowHandle();
browser.findElement( By.cssSelector(".desktop-userIconsContainer") ).click();
browser.findElement( By.linkText("LOGIN") ).click();
browser.findElement( By.id("gPlusLogin") ).click();

for (String googleHandle : browser.getWindowHandles() ){
        browser.switchTo().window(googleHandle);
}

new WebDriverWait(browser, 10)
    .until(ExpectedConditions.elementToBeClickable( By.id( "identifierId" ) )).sendKeys("yoyo");
browser.switchTo().window(parentHandle);  // use this for switching back to parent window