driver.get("something");
Thread.sleep(1000);
//Alternative to javaScript is to use Actions Class and send ESC key to stop execution
//Actions actions = new Actions(driver);
//actions.sendKeys(Keys.ESCAPE);

((JavascriptExecutor) driver).executeScript("window.stop;");
driver.quit();