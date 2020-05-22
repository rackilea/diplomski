Set<String> handles = driver.getWindowHandles();  
for (String handle : handles) {
    if (!handle.equals(mainWindow)) {
          driver.switchTo().window(handle);
          break;
    }
}