package de.scrum_master.app;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Closeable;
import java.io.IOException;

public class Application implements Closeable {
    private final WebDriver driver;

    public Application() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Override
    public void close() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void doSomething() {
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_hidden");

        // Button in main frame
        WebElement button = driver.findElement(By.className("seeResult"));
        // Text field in iframe
        driver.findElement(By.name("fname"));
        // Text area in main frame
        driver.findElement(By.id("textareaCode"));
        // Hidden input field in main frame
        driver.findElement(By.name("bt"));
        // Hidden input field in iframe
        WebElement hiddenCountryField = driver.findElement(By.name("country"));

        // Click button in main frame. This *refreshes* the iframe, making all existing
        // references to elements therein (e.g. 'hiddenCountryField') stale
        button.click();

        // Get value of hidden input field after iframe refresh
        System.out.println(driver.findElement(By.name("country")).getAttribute("value"));

        // This alternative would *not* work because the aspect cannot repair a reference
        // to an element which is gone forever because the iframe was refreshed
        // System.out.println(hiddenCountryField.getAttribute("value"));

        // Click submit button in iframe (triggers both advices)
        driver.findElement(By.cssSelector("input[type=submit]")).click();
    }

    public static void main(String[] args) {
        try (Application application = new Application()) {
            application.doSomething();
        }
    }
}