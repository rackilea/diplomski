WebDriverWait wait = new WebDriverWait(driver, 5);
JavascriptExecutor jse = (JavascriptExecutor)driver;

// get the last element
By lastChild = By.cssSelector("#list > div:last-of-type");
WebDriver elem = driver.findElement(lastChild);

// scroll the last element at the top
jse.executeScript("arguments[0].scrollIntoView(true);", elem);

// wait for a new element at the end
wait.until((WebDriver drv) -> !elem.equals(drv.findElement(lastChild)))