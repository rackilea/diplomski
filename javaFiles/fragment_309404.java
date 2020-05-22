public ExpectedCondition<Boolean> waitForElementToHaveText(final WebElement element, final String expectedText) {
    return new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            try {
                return element.getText().equals(expectedText);
            } catch (Exception e) {
                return false; // catchall fail case
            }
        }

        public String toString() {
            return "an element to have specific text";
        }
    };
}