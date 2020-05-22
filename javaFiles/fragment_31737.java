Actions actions = new Actions(driver);
actions
    .moveToElement(resizeableWindow)
    .clickAndHold(resizeableWindow)
    .moveByOffset(50,50)
    .perform();