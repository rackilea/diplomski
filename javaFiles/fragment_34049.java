String winHandleBefore = driver.getWindowHandle(); //save the current window handle

for(String winHandle : driver.getWindowHandles()){
 driver.switchTo().window(winHandle);
} //switch window

driver.close(); //close the new window

driver.switchTo().window(winHandleBefore); //switch again to the first window