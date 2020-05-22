Set<String> handles = driver.getWindowHandles();
    String currentHandle = driver.getWindowHandle();
    for (String handle : handles) {
     if (!handle.equals(currentHandle)) {
         driver.switchTo().window(handle);
         if(whatImLookingFor)
             break;
     }
   }