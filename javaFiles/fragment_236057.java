void checkAlert() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    } catch (Exception e) {
        //exception handling
    }
}

Or 
implicit wait
    driver.switchTo().window(newWindow);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS