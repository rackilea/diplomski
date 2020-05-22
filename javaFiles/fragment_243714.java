public void typeInColumn(int index, String content) {
    switchToFrame();

    WebElement column = driver.findElement(COLS_LOC[index]);

    Actions build = new Actions(driver);
    build.moveToElement(column).click().sendKeys(content).build().perform();

    switchToDefault();
}