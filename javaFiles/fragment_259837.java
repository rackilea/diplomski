String mwh=driver.getWindowHandle(); // Get current window handle
Set<String> s=driver.getWindowHandles();
Iterator<String> ite=s.iterator();
String popupHandle = "";
while(ite.hasNext())
{
    popupHandle = ite.next().toString();
    if(!popupHandle.contains(mwh)) // If not the current window then shift focus and close them
    {
         driver.switchTo().window(popupHandle);
         driver.close();
    }
 }
 driver.switchTo().window(mwh); // finally move control to main window.