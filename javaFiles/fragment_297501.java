import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class BrowserManagementListener implements ITestListener {
  private static final String BROWSER = "browser";

  private File file =
      new File("\\\\192.168.70.39\\IT Share\\Automation\\ERP Automation\\credential.properties");
  private Properties prop = new Properties();

  public static RemoteWebDriver getDriver() {
    ITestResult result = Reporter.getCurrentTestResult();
    if (result == null) {
      throw new IllegalStateException("could not detect a valid test result");
    }
    Object object = result.getAttribute(BROWSER);
    if (object == null) {
      throw new IllegalStateException("could not find a browser");
    }
    return (RemoteWebDriver)object;
  }

  @Override
  public void onTestStart(ITestResult result) {
    // This line retrieves the value of
    // <parameter name="browser" value="chrome"/> from your testng suite xml
    String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
    if ("chrome".equalsIgnoreCase(browser)) {
      FileInputStream fileInput = null;
      try {
        fileInput = new FileInputStream(file);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      try {
        prop.load(fileInput);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    ChromeOptions options = new ChromeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.NONE);
    RemoteWebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    result.setAttribute(BROWSER, driver);
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    cleanUpBrowser(result);
  }

  @Override
  public void onTestFailure(ITestResult result) {
    Object object = result.getAttribute(BROWSER);
    if (object == null) {
      return;
    }

    RemoteWebDriver driver = (RemoteWebDriver) object;

    File srcFile = driver.getScreenshotAs(OutputType.FILE);

    File destFile = new File("test-output/" + result.getName() + ".png");
    try {
      FileUtils.copyFile(srcFile, destFile);
      System.out.println("Screenshot is been taken for failed test case: " + result.getName());
      System.err.println("Screenshot below" + destFile.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      cleanUpBrowser(result);
    }
  }

  private void cleanUpBrowser(ITestResult result) {
    Object driver = result.getAttribute(BROWSER);
    if (driver != null) {
      ((RemoteWebDriver) driver).quit();
      result.setAttribute(BROWSER, null);
    }
  }
}