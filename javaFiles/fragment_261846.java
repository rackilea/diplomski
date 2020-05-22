driver = new ChromeDriver();
    driver.manage().window().maximize();

    baseUrl = "http://www.google.co.uk/";
    driver.get(baseUrl);
    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1)); //switches to new tab
    driver.get("https://www.facebook.com");

    driver.switchTo().window(tabs.get(0)); // switch back to main screen        
    driver.get("https://www.news.google.com");