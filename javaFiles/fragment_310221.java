public static ExpectedCondition<Boolean> selectContainsOption(
    final WebElement select, final By locator) {

    return new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            try {
                return elementIfVisible(select.findElement(locator));
            } catch (StaleElementReferenceException e) {
                return null;
            }
        }
    };
}