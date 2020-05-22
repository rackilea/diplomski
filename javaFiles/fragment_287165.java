Actions cursor = new Actions(driver);
    cursor.moveToElement(customNumberLink).perform();
    cursor.click();     

    // move to SAME element to leave cursor where it is while Javascript runs.
    cursor.moveToElement(customNumberLink).perform();

    // now grab newly generated elements
    WebElement clearLink = customNumberCell.findElement(By.cssSelector("a.clear"));
    clearLink.click();