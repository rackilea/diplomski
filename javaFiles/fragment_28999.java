driver.get("https://www.online-calculator.com/full-screen-calculator/");
new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullframe")));
WebElement canvas = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
//clicking on 3
new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(0,(255/6)*3).click().build().perform();
//clicking on the substract sign (-)
new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*2,(255/6)*3).click().build().perform();
//clicking on 1
new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*4,(255/6)*3).click().build().perform();
//clicking on equals to sign (=)
new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*4,(255/6)*4).click().build().perform();