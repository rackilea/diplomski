WebDriver chromeDriver;

@BeforeTest
public void setup() throws Exception {
  System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
  chromeDriver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("url");
}