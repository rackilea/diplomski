WebDriver webDriver = new FireFoxDriver();
 Actions actions = new Actions(webDriver);
 webDriver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/events");
 Thread.sleep(500);
 WebElement drop = webDriver.findElement(By.cssSelector("#droptarget"));
 //movetoelement should be center and is
 actions.moveToElement(drop).contextClick().perform();
 Thread.sleep(500);
 webDriver.quit();