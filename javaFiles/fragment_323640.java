package example.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Parallel Selenium WebDriver example for http://stackoverflow.com/questions/30353996/selenium-and-parallelized-junit-webdriver-instances
 * Parallelized class is like http://hwellmann.blogspot.de/2009/12/running-parameterized-junit-tests-in.html
 */
@RunWith(Parallelized.class)
public class ParallelSeleniumTest {

    /** Available driver types */
    enum WebDriverType {
        CHROME,
        FIREFOX
    }

    /** Create WebDriver instances for specified type */
    static class WebDriverFactory {
        static WebDriver create(WebDriverType type) {
            WebDriver driver;
            switch (type) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException();
            }
            log(driver, "created");
            return driver;
        }
    }

    // for description how to user Parametrized
    // see: https://github.com/junit-team/junit/wiki/Parameterized-tests
    @Parameterized.Parameter
    public WebDriverType currentDriverType;

    // test case naming requires junit 4.11
    @Parameterized.Parameters(name= "{0}")
    public static Collection<Object[]> driverTypes() {
        return Arrays.asList(new Object[][] {
                { WebDriverType.CHROME },
                { WebDriverType.FIREFOX }
            });
    }

    private static ThreadLocal<WebDriver> currentDriver = new ThreadLocal<WebDriver>();
    private static List<WebDriver> driversToCleanup = Collections.synchronizedList(new ArrayList<WebDriver>());

    @BeforeClass
    public static void initChromeVariables() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    }

    @Before
    public void driverInit() {
        if (currentDriver.get()==null) {
            WebDriver driver = WebDriverFactory.create(currentDriverType);
            driversToCleanup.add(driver);
            currentDriver.set(driver);
        }
    }

    private WebDriver getDriver() {
        return currentDriver.get();
    }

    @Test
    public void searchForChromeDriver() throws InterruptedException {
        openAndSearch(getDriver(), "chromedriver");
    }

    @Test
    public void searchForJunit() throws InterruptedException {
        openAndSearch(getDriver(), "junit");
    }

    @Test
    public void searchForStackoverflow() throws InterruptedException {
        openAndSearch(getDriver(), "stackoverflow");
    }

    private void openAndSearch(WebDriver driver, String phraseToSearch) throws InterruptedException {
        log(driver, "search for: "+phraseToSearch);
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(phraseToSearch);
        searchBox.submit();
        Thread.sleep(3000);
    }

    @AfterClass
    public static void driverCleanup() {
        Iterator<WebDriver> iterator = driversToCleanup.iterator();
        while (iterator.hasNext()) {
            WebDriver driver = iterator.next();
            log(driver, "about to quit");
            driver.quit();
            iterator.remove();
        }
    }

    private static void log(WebDriver driver, String message) {
        String driverShortName = StringUtils.substringAfterLast(driver.getClass().getName(), ".");
        System.out.println(String.format("%15s, %15s: %s", Thread.currentThread().getName(), driverShortName, message));
    }

}