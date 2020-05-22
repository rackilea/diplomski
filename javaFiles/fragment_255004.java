public void isElementExistingAlternateResult(WebElement element) {
    boolean isElementFound = true;
    try {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    } catch (Exception e) {
        isElementFound = false;
    }

    if (isElementFound == true) {
        System.out.println("test is continued...");
    } else {
        Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
        System.out.println("next level not unlocked.");
    }