import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassExample {

  //We use thread local so that even if you decide to run tests in parallel, every @Test method
  //will get its own AndroidDriver instance
  private static final ThreadLocal<AndroidDriver> drivers = new ThreadLocal<>();

  @BeforeMethod
  public void setupDriver() throws MalformedURLException {
    File f = new File("src");
    File fs = new File(f, "ApiDemos-debug.apk");
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "demo");
    capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
    AndroidDriver driver =
        new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    drivers.set(driver);
  }

  @AfterMethod
  public void cleanupDriver() {
    drivers.get().quit();
    drivers.remove();
  }

  @Test
  public void testMethod() throws InterruptedException {
    AndroidDriver driver = drivers.get();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

    driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();

    driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

    driver.findElementByXPath("//*[@content-desc='9']").click();

    Thread.sleep(1000);

    TouchAction t = new TouchAction(driver);

    WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
    WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
    t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2)))
        .moveTo(element(second))
        .release()
        .perform();
  }
}