System.setProperty("webdriver.gecko.driver","D:/Application/geckodriver.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get("https://www.twingly.com/ping");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.switchTo().frame(driver.findElement(By.className("ping-iframe")));
driver.findElement(By.id("ping-box")).sendKeys("http://www.google.com");
driver.findElement(By.id("ping-button")).click();