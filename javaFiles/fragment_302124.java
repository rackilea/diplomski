package brucey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class WebDriverSetup {
    public static WebDriver driver;
    public static String driverPath = "C:\\Users\\pburgr\\Desktop\\selenium-tests\\FF_driver_0_23\\geckodriver.exe";
    public static WebDriver startFF() {
        FirefoxOptions options = new FirefoxOptions();
        ProfilesIni allProfiles = new ProfilesIni();         
        FirefoxProfile selenium_profile = allProfiles.getProfile("selenium_profile");
        options.setProfile(selenium_profile);
        options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void shutdownFF() {
        driver.quit();
    }
}