function manipulatePopUp(final WebDriver driver, final WebDriverWait wait) {
    final String mainWindowHandle = driver.getWindowHandle();
    driver.findElement(By.id("linkThatOpensPopUp")).click();

    wait.until(new ExpectedConditions<Boolean>() {
        @Override
        public Boolean apply(WebDriver d) {
            return (d.getWindowHandles().size() != 1);
        }
    });

    for (String activeHandle : driver.getWindowHandles()) {
        if (!activeHandle.equals(mainWindowHandle)) {
            driver.switchTo().window(activeHandle);
        }
    }

    driver.close();
    driver.switchTo().window(mainWindowHandle);
}