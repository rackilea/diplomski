public static WebElement getElmObject(String locinfo, String loctype) {
    try {
        Method method = By.class.getMethod(loctype, String.class);
        By by = (By) method.invoke(By.class, locinfo);
        return driver.findElement(by);
    } catch (Throwable t) {
        return null;
    }
}