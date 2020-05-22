package automationFramework;

    import java.util.concurrent.TimeUnit;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.ie.InternetExplorerDriver;
    import org.openqa.selenium.remote.DesiredCapabilities;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Parameters;
    import org.testng.annotations.Test;

    import pageObject.devSplashScreenPage;
    import utility.BrowserType;
    import utility.Constant;
    import appModule.SignIn_Action;

    public class SignIn {

    public WebDriver driver;



    @BeforeMethod
    @Parameters("browser")
    public void SetUp(String browser) {

        driver = BrowserType.Execute(browser);

    }

    @Test
    public  void signIn() {

        // Call Sign In function
        SignIn_Action.Execute(driver, Constant.StudentUsername, Constant.StudentPassword);    
     }  

    @AfterMethod
    public void Teardown() {
          driver.quit();

    } 

      }