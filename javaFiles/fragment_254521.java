public static boolean elementIsPresent(AndroidElement element) {
    try {
        element.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException e) {
        return false;
    }

    return true;
}