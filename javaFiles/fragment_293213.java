public void scrollByText(String menuText) {

        try {

             driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + menuText + "\").instance(0));")); 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }