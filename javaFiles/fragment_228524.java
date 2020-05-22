//setting the timeout for our wait to be 20 seconds (you can use whatever you want)
WebDriverWait myWaitVar = new WebDriverWait(driver,20); 
try {
    WebElement myElement = myWaitVar.until(ExpectedConditions.elementToBeClickable(firstName)));
    //assert test failed!
}
catch(timeoutException timeout) {
    //whatever you want to do when the element is not clickable
}