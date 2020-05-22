url = "http://facebook.com";
    String email = "email";
    String password = "password";
    System.setProperty("webdriver.chrome.driver", "src/chromedriver 3");
    WebDriver driver = new ChromeDriver(); 
    driver.get(url);
    driver.manage().window().maximize();
    driver.findElement(By.id("email")).sendKeys("your email id");
    driver.findElement(By.id("pass")).sendKeys("Your password" + Keys.ENTER);
    WebDriverWait wait = new WebDriverWait(driver, 500);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[contains(@title,'Share an update')]")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@title,'Share an update')]")));
     driver.findElement(By.xpath("//textarea[contains(@title,'Share an update')]")).click();

     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@contenteditable='true']")));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@contenteditable='true']")));
   driver.findElement(By.xpath("//div[@contenteditable='true']")).sendKeys("Hello World");