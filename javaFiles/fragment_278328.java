public void TapByText(String buttonText) {
        String buttonName="new UiSelector().text(\"MY_TEXT\")".replace("MY_TEXT", buttonText);
        @SuppressWarnings("unchecked")
        List<WebElement> el = (List<WebElement>) driver.findElements(MobileBy.AndroidUIAutomator(buttonName));
        System.out.println(el.size());
        new TouchAction(driver).press(ElementOption.element(el.get(0))).waitAction().release().perform();

    }