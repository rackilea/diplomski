public static WebDriver driverRestart(WebDriver driver, String startingUrl) throws MalformedURLException {
    try {
        driver.close();
    } catch (WebDriverException e) {
        log.error("#### oops, seems driver instance have been already closed. Doing re-initialization right now!", e.getMessage(), e);
    }
    return driverInit(driver, startingUrl);
}