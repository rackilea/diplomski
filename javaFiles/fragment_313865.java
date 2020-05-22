public static boolean elementIsPresent(MobileElement element) {
        try {
            element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
        return true;
    }