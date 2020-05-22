WebDriver driver=new FirefoxDriver();
//First navigating to Yahoo site
driver.get("http://www.Yahoo.com");
//Capturing the window handle
String strMainWindowHandle=driver.getWindowHandle();
//For better understanding printing the page title
System.out.println(driver.getTitle());

//Now opening a new window
driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL+"n");
Set<String> winHandles=driver.getWindowHandles();
for(String handle:winHandles)
    driver.switchTo().window(handle);
//Navigating to Google site with new window i.e new window handle 
driver.get("http://www.google.com");
//For better understanding printing the page title
System.out.println(driver.getTitle());

//Switching back control to main Window which captured earlier
driver.switchTo().window(strMainWindowHandle);
System.out.println(driver.getTitle());