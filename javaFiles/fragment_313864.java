public static boolean elementIsPresent(MobileElement element) {
    try {
        return element.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException e) {
        return false;
    }
}