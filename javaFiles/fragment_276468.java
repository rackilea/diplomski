public class DataProviderTest {

private static WebDriver driver;

@DataProvider(name = "Authentication")

 public static Object[][] credentials() {

    return new Object[][] { { "a", "a" }, { "b", 
"b" }};

 }

 // Here we are calling the Data Provider object with its Name

 @Test(dataProvider = "Authentication")

 public void test(String sUsername, String sPassword) {

  driver = new FirefoxDriver();

  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  driver.get("http://yoursite.com");

  driver.findElement(By.xpath(".//*[@id='account']/a")).click();

  driver.findElement(By.id("log")).sendKeys(sUsername);

  driver.findElement(By.id("pwd")).sendKeys(sPassword);

  driver.findElement(By.id("login")).click();

  driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

  driver.quit();

  }

}