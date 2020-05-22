ExpectedCondition e = new ExpectedCondition<Boolean>() {
    public Boolean apply(WebDriver driver) {
        return driver.findElements(By.cssSelector("div[id*='div']")).size() >= 2;
    }
};

WebDriverWait wait = new FluentWait<WebDriver>(driver)
                   .withTimeout(12, TimeUnit.SECONDS)
                   .pollingEvery(2, TimeUnit.SECONDS)
                   .ignoring(NoSuchElementException.class);
wait.until(e);