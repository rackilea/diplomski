public boolean isValidationMsgNotExist() {
    try {
        driver.findElement(By.name("MessageTable"));
        return false;
    } catch (NoSuchElementException e) {
        return true;
    }
}