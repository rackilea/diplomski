MobileElement makeTextLocartor = (MobileElement) wd
            .findElementByAndroidUIAutomator("new UiSelector().description(\"<text>\")");
    makeTextLocartor.click();

    MobileElement TextLocartor = (MobileElement) wd
            .findElementByAndroidUIAutomator("new UiSelector().text(\"<text>\")");
    makeTextLocartor.click();

    wd.findElementById("android:id/button1").click();


    WebElement findElementById = wd.findElementById("com.android.chrome:id/url_bar");
    String text = findElementById.getText();
    System.out.println(text);