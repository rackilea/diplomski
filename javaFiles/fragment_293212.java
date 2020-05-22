public void scrollByID(String Id, int index) {

        try {

             driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+Id+"\").instance("+index+"));")); 

        } catch (Exception e) {
           e.printStackTrace();
        }
    }