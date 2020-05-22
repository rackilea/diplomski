FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
    wait.withTimeout(Duration.ofSeconds(20));
    wait.pollingEvery(Duration.ofSeconds(5));
    wait.ignoring(NoSuchElementException.class);

     boolean status = wait.until(new Function<WebDriver, Boolean>() {
        public Boolean apply(WebDriver driver) {
            return driver.findElement(By.name("q")).isDisplayed();
        }
    });