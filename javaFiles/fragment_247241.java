public ExpectedCondition<WebElement> customCondition(By... locators) {
    @Override
    public WebElement apply(WebDriver d) {
        for (By locator in locators) {
            return ExpectedConditions.elementToBeClickable(locator).apply(d);
        }
    }
}

WebElement element = wait4.until(customCondition(By.xpath("//a[@data-period='R6M']"), By.xpath("//span[@title='FYTD']")));