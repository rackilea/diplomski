WebElement elem = driver.findElement(By.className("ytp-progress-bar"));

    int width = elem.getSize().getWidth();

    Actions act = new Actions(driver);
    act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();