try {
    WebElement popUp = driver.findElement(By./**your expression**/);
    popUp.click();  
} catch(NoSuchElementException | StaleElementReferenceException e) {
    log.debug("Impossible to click the pop-up. Reason: " + e.toString());
}