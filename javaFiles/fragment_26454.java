WebElement elem = null;
try {
    elem = driver.findElement(By.id("someId"));
} catch (NoSuchElementException e) {
    log.error(e.getMessage());
    throw e;    // or not if this error was expected, program then continues
}