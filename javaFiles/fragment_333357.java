// Store the current window handle
String winHandleBefore = driver.getWindowHandle();

 // Switch to new window opened
for(String winHandle : driver.getWindowHandles()){
driver.switchTo().window(winHandle);
 }

// Perform the actions on new window

// Close the new window, if that window no more required
driver.close();

 // Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);