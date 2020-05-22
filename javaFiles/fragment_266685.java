WebDriver driver = new FirefoxDriver();     
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("http://www.thomson.co.uk/holidays.html");

// optional, unnecessary in your case
// driver.switchTo().defaultContent(); // make sure outside of all iframes

// switch to search frame
WebElement searchFrame = driver.findElement(By.cssSelector("iframe[src='/thomson/page/byo/search/usp.page']"));
driver.switchTo().frame(searchFrame);

driver.findElement(By.id("searchbutton")).click();
driver.findElement(By.id("holidayAttribute_1")).click();
driver.findElement(By.id("holidayAttribute_2")).click();
driver.findElement(By.id("holidayAttribute_3")).click();