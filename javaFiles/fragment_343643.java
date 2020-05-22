public static boolean isElementLoaded(WebDriver driver, By findBy) {
    try {
        driver.findElement(findBy));
    } catch (NoSuchElementException e) {
        return false;
    } 
    return true;     
}