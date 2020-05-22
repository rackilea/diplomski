UiObject wifi = new UiObject(new UiSelector().text("Successfull"));
boolean result = wifi.waitForExists(40000);//40 secs specified as timeout in ms
if(!result){ //View not found in 40 secs
   // throw error
}
wifi.clickAndWaitForNewWindow();