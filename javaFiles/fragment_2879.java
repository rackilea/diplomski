boolean draggedAndDropped = false;
   while(!draggedAndDropped ) {
   try{
     source = driver.findElement(By.xpath(OR.getProperty("searchedUserSource")));
     destination = driver.findElement(By.xpath(OR.getProperty("userDestination")));
     dragAndDrop(source, destination);
     draggedAndDropped  = true;
   } catch(StaleElementReferenceException e) {
      System.out.println("StaleElementReferenceException caught, trying again");
  }