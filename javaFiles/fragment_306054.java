WebDriver driver = new FirefoxDriver();
WebDriverWait wait = new WebDriverWait(driver, 20);
driver.get("http://stackoverflow.com");

// get the intrinsic size with the getAttribute method
WebElement ele = driver.findElement(By.cssSelector("img"));
String naturalWidth = ele.getAttribute("naturalWidth");
String naturalHeight = ele.getAttribute("naturalHeight");

// get the intrinsic size with a piece of Javascript
ArrayList result = (ArrayList)((JavascriptExecutor) driver).executeScript(
        "return [arguments[0].naturalWidth, arguments[0].naturalHeight];", ele);
Long naturalWidth2 = (Long)result.get(0);
Long naturalHeight2 = (Long)result.get(1);