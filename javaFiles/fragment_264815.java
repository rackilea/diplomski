package com.rationaleemotions.stackoverflow.qn46323434;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class BrowserSpawner implements ISuiteListener {
    private static final String DRIVER = "driver";

    @Override
    public void onStart(ISuite suite) {
        RemoteWebDriver driver;
        String browserType = suite.getParameter("browserType");
        switch (browserType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }
        suite.setAttribute(DRIVER, driver);
    }

    @Override
    public void onFinish(ISuite suite) {
        Object driver = suite.getAttribute(DRIVER);
        if (driver == null) {
            return;
        }
        if (!(driver instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        ((RemoteWebDriver) driver).quit();
        suite.setAttribute(DRIVER, null);
    }

    public static RemoteWebDriver getDriver() {
        ITestResult result = Reporter.getCurrentTestResult();
        if (result == null) {
            throw new UnsupportedOperationException("Please invoke only from within an @Test method");
        }
        Object driver = result.getTestContext().getSuite().getAttribute(DRIVER);
        if (driver == null) {
            throw new IllegalStateException("Unable to find a valid webdriver instance");
        }
        if (! (driver instanceof RemoteWebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        return (RemoteWebDriver) driver;
    }
}