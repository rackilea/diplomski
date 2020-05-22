public static void waitForElement(WebElement element){
    try {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(60000))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        waiting(100);
        //can add further action here
    } catch (Exception e) {
        e.printStackTrace();
    }
}