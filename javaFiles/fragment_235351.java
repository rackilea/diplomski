String waitForAngularJs ="Your javascript goes here"; // as it is lengthy read it from file and store here.
ExpectedCondition<Boolean> waitForAngular= new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeAsyncScript(waitForAngularJs).equals(true);
            }
};

 WebDriverWait wait = new WebDriverWait(driver, 60);
 wait.until(waitForAngular);