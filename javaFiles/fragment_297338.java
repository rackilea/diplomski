System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
WebDriver driver =  new FirefoxDriver();
driver.get("https://www.facebook.com/");
driver.findElement(By.cssSelector("input#email")).sendKeys("Selenium");
driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("Automation");
driver.findElement(By.cssSelector("input[value='Log In']")).click();