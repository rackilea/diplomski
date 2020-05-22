public static boolean letWebDriverRealizeThisWindowHasBeenClosed(WebDriver driver,
            String closedWindowHandle) {
        /**
         * to avoid infinite loop, do write a break when definite time has been passed
         */
        /**
         * Generally, this method returns true given that window is closed
         */

    boolean isWebDriverRealized = false;
    long start = System.currentTimeMillis();
    long end = start + (30 * 1000); //30 seconds
    while (!isWebDriverRealized 
            && System.currentTimeMillis() < end) {
        try {
            driver.switchTo().window(closedWindowHandle);
        } catch (NoSuchWindowException nswe) {
            isWebDriverRealized = true;
        }
    }
    return isWebDriverRealized;
}