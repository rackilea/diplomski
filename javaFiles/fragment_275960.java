//Do some click action to render alert.
    //statement to wait for an alert.
    WebDriverWait wait = new WebDriverWait(driver,
            30);
    wait.until(ExpectedConditions.alertIsPresent());
   //accepting the alert
   driver.switchTo().alert().accept();