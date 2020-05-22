//Clicking and opening Partial Link Text in new tab
    WebElement element = driver.findElement(By.linkText("Partial Link Test"));
    Actions act = new Actions(driver);
    act.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    //Clicking and opening Link Text in new tab
    element = driver.findElement(By.linkText("Link Test"));
    act.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();