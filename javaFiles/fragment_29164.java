package testNGresearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import multipleTest.Loginer;

public class AllLoginTestsNG{

    public static WebDriver driver;
    String baseUrl = "https://9gag.com/";
    @BeforeTest
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void GetUrl() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(1500);
     }

    @Test(priority = 2)
    public void cancelSignUp() {
        driver.close();
    }

}