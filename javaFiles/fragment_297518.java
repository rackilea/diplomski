WebDriver driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get("example.com");
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='navbar-items']/ul/li[2]/a")));
driver.findElement(By.xpath(".//*[@id='navbar-items']/ul/li[2]/a")).click();