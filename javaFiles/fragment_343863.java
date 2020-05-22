static void waitForPageLoad(WebDriver wdriver) {
    WebDriverWait wait = new WebDriverWait(wdriver, 60);

    Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {

        @Override
        public boolean apply(WebDriver input) {
            return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
        }

    };
    wait.until(pageLoaded);
}