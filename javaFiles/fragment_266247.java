public static boolean isPresentAndDisplayed(final WebElement element) {
    try {
        return element.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}