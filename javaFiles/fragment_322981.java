package SeleniumProject.selenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class ChromeTest extends TestCase {

    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass
    public static void createAndStartService() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("D:\\Downloads\\chromedriver_win32\\chromedriver.exe"))
                .withVerbose(false).usingAnyFreePort().build();
        try {
            service.start();
        } catch (IOException e) {
            System.out.println("service didn't start");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new RemoteWebDriver(service.getUrl(), capabilities);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Load a new web page in the current browser window.
        driver.get("http://steamcommunity.com/id/Winning117/games/?tab=all");

        // Executes JavaScript in the context of the currently selected frame or
        // window.
        ArrayList<Map> list = (ArrayList<Map>) js.executeScript("return rgGames;");
        // Map represent properties for one game
        for (Map map : list) {
            for (Object key : map.keySet()) {
                // take each key to find key "name" and compare its vale to
                // Cluckles' Adventure
                if (key instanceof String && key.equals("name") && map.get(key).equals("Cluckles' Adventure")) {
                    // print all properties for game Cluckles' Adventure
                    map.forEach((key1, value) -> {
                        System.out.println(key1 + " : " + value);
                    });
                }
            }
        }
    }
}