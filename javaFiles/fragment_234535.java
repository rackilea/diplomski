public static ExpectedCondition<Boolean> invisibilityOfAllElements(
        final List<WebElement> elements) {
    return new ExpectedCondition<Boolean>() {

        @Override
        public Boolean apply(WebDriver webDriver) {
            for (WebElement element : elements) {
                try {
                    if (element.isDisplayed()) {
                        return false;
                    }
                } catch (StaleElementReferenceException | NoSuchElementException ex) {
                    // ignore
                }
            }
            return true;
        }

        @Override
        public String toString() {
            return "invisibility of all elements " + elements;
        }
    };
}