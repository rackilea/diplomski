System.setProperty("webdriver.gecko.driver","C:\\Utility\\BrowserDrivers\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.get("https://staging.keela.co/login");
WebDriverWait wait = new WebDriverWait (driver, 15);
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-email']")));
element.sendKeys("bandanakeela@yopmail.com");
driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("keela");
driver.findElement(By.xpath("//button[@class='btn btn-sm btn-block btn-primary']")).click();