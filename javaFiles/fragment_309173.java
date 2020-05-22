public class YourStepDefinitions {

    private Scenario myScenario;

    @Before()
    public void embedScreenshotStep(Scenario scenario) {

        myScenario = scenario;

    }

    @Then ("^I take a screenshot$")
    public void i_take_a_screenshot() throws Throwable {

        try {
            myScenario.write("Current Page URL is " + driver.getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            myScenario.embed(screenshot, "image/png");  // Stick it in the report
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            log.error(somePlatformsDontSupportScreenshots.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}