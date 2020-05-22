public class TestContext {

  static ThreadLocal<WebDriver> CURRENT_DRIVER = new ThreadLocal<>();

  public static WebDriver currentDriver(){
    return CURRENT_DRIVER.get();
  }

   public void beforeTest(RemoteWebDriver driver) {
    CURRENT_DRIVER.set(driver);
   }
}