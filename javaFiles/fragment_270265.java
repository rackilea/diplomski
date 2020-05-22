// get original tab handle
String currentHandle = driver.getWindowHandle();

// open the new tab here

// switch to the new tab
for (String handle : driver.getWindowHandles()) {
    if (!handle.equals(currentHandle))
    {
        driver.switchTo().window(handle);
    }
}

driver.findElement(By.linkText("Search")).click();

// close the new tab and switch back to the old tab
driver.close();
driver.switchTo().window(currentHandle);