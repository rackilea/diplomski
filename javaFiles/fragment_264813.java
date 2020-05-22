package com.rationaleemotions.stackoverflow.qn46323434;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

@Listeners(BrowserSpawner.class)
public class MyBaseClass {
    protected void launchPage(String url) {
        RemoteWebDriver driver = BrowserSpawner.getDriver();
        driver.get(url);
        System.err.println("Page Title :" + driver.getTitle());
    }
}