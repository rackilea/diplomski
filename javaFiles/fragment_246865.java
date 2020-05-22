public LoginPage fill(String input, By locator) {
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(input);

    return new LoginPage(driver);
}