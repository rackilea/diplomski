public void scroll(int x, int y) {
    int startY = (int) (driver.manage().window().getSize().getHeight() * 0.90);
    int endY = (int) (driver.manage().window().getSize().getHeight() * 0.10);
    TouchAction action = new TouchAction(driver);
    action.press(point(x, startY)).waitAction(waitOptions(ofSeconds(3))).moveTo(point(x, endY)).release().perform();
}

MobileElement startElement = (MobileElement) driver.findElementById("mention parent element here");
Point location = startElement.getLocation();
    homepage.scroll(location.x,location.y);