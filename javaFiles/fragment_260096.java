driver.findElement(By.name("mercurymessages")).click();

    //wait for 20 seconds 
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("u_0_5")));
    driver.findElement(By.id("u_0_5")).click();//To click on Send a New Message Link

    //To enter a name into the to field 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='inputtext textInput']")));
    WebElement friendName = driver.findElement(By.xpath("//input[@class='inputtext textInput']"));

    friendName.sendKeys("Deep");//Change it with your friend name

    //wait for the user list to appear
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='user selected']")));
    friendName.sendKeys(Keys.ENTER);

    WebElement messageBox = driver.findElement(By.xpath("//textarea[@class='uiTextareaAutogrow _552m']"));
    wait.until(ExpectedConditions.visibilityOf(messageBox));
    messageBox.sendKeys("Hi there");

    messageBox.sendKeys(Keys.ENTER);