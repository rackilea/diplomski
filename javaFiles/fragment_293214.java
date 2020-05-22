public void scrollToBottom() {

      int  x = driver.manage().window().getSize().width / 2;
      int start_y = (int) (driver.manage().window().getSize().height * 0.2);
      int end_y = (int) (driver.manage().window().getSize().height * 0.8);
        TouchAction dragNDrop = new TouchAction(driver)
                        .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(x, end_y))
                        .release();
        dragNDrop.perform();
    }