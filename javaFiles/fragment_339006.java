public void waitUntilTextIsPresent(WebElement element, String regex, long timeout, long polling) {
        final WebElement webElement = element;
        final String regex = regex;

        new FluentWait<WebDriver>(driver)
        .withTimeout(timeout, TimeUnit.SECONDS)
        .pollingEvery(polling, TimeUnit.MILLISECONDS)
        .until(new Predicate<WebDriver>() {

            public boolean apply(WebDriver d) {
                return (webElement.getText().matches(regex); 
            }
        });
}