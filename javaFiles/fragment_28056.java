Point point = element.getLocation();
int x = point.x;
int y = point.y;

TouchAction touchAction = new TouchAction(driverMobile);
touchAction.tap(x, y).perform();