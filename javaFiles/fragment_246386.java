WebDriverWait wait = new WebDriverWait(driver, 60);
Actions act = new Actions(driver);

WebElement postBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("xhpc_message")));
act.moveToElement(postBox).click().build().perform();

WebElement postBox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1mf._1mj")));
act.moveToElement(postBox2).click().sendKeys("Hello Post").build().perform();

WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#feedx_sprouts_container button[type=submit]")));
postButton.click();