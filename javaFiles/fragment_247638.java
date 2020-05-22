package de.scrum_master.aspect;

import de.scrum_master.app.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public aspect IFrameSwitcher {
    WebElement around(WebDriver driver, By by) :
        !within(IFrameSwitcher) &&
            call(WebElement WebDriver+.findElement(*)) &&
            target(driver) &&
            args(by)
        {
            System.out.println(thisJoinPoint + " -> " + by);
            WebElement webElement;
            try {
                System.out.print("  Trying main frame -> ");
                driver.switchTo().defaultContent();
                webElement = proceed(driver, by);
                System.out.println("OK");
                return webElement;
            }
            catch (RuntimeException e) {
                System.out.println(e.getClass().getSimpleName());
                for (WebElement iframe : driver.findElements(By.tagName("iframe"))) {
                    try {
                        System.out.print("  Trying iframe " + iframe.getAttribute("id") + " -> ");
                        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
                        webElement = proceed(driver, by);
                        System.out.println("OK");
                        return webElement;
                    }
                    catch (RuntimeException e2) {
                        System.out.println(e2.getClass().getSimpleName());
                        e = e2;
                    }
                }
                throw e;
            }
        }

    void around(Application application, WebElement webElement) :
        within(Application) &&
        call(void WebElement+.click()) &&
        this(application) &&
        target(webElement)
    {
        System.out.println(thisJoinPoint + " -> " + webElement);
        WebDriver driver = application.getDriver();
        try {
            System.out.print("  Trying main frame -> ");
            driver.switchTo().defaultContent();
            proceed(application, webElement);
            System.out.println("OK");
        }
        catch (RuntimeException e) {
            System.out.println(e.getClass().getSimpleName());
            for (WebElement iframe : driver.findElements(By.tagName("iframe"))) {
                try {
                    System.out.print("  Trying iframe " + iframe.getAttribute("id") + " -> ");
                    driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
                    proceed(application, webElement);
                    System.out.println("OK");
                    return;
                }
                catch (RuntimeException e2) {
                    System.out.println(e2.getClass().getSimpleName());
                    e = e2;
                }
            }
            throw e;
        }
    }
}