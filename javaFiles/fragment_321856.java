protected static <T> T waitECTimeoutWrapped(WebDriver driver, ExpectedCondition<T> ec, int timeout) {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    T data = waitDriver.until(ec);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    return data;
}