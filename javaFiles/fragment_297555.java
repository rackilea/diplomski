public static void swipeHorizontal(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
            Dimension size = driver.manage().window().getSize();
            int anchor = (int) (size.height * anchorPercentage);
            int startPoint = (int) (size.width * startPercentage);
            int endPoint = (int) (size.width * finalPercentage);
            new TouchAction(driver).press(startPoint, anchor).waitAction(Duration.ofMillis(duration)).moveTo(endPoint, anchor).release().perform();
        }