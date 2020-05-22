@After
public void finish(Scenario scenario) {
    try {
        byte[] screenshot =
        helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    } catch (WebDriverException somePlatformsDontSupportScreenshots) {

    System.err.println(somePlatformsDontSupportScreenshots.getMessage());
    }
    finally {
        helper.getWebDriver().close();
    }
}