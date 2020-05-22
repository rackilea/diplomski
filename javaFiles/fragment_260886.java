//Store the current window handle
String currentWindowHandle = this.webDriver.getWindowHandle();

//run your javascript and alert code
((JavascriptExecutor)this.webDriver).executeScript("alert('Test')"); 
this.webDriver.switchTo().alert().accept();

//Switch back to to the window using the handle saved earlier
this.webDriver.switchTo().window(currentWindowHandle);