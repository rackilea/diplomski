Set<String> window = driver.getWindowHandles();
    String window1 = (String) window.toArray()[0];
    String window2 = (String) window.toArray()[1];
   // String window3 = (String) window.toArray()[2];
    driver.switchTo().window(window2);
    driver.findElement(By.id("button1")).click();
    Set<String> win = driver.getWindowHandles();
    String window3 = (String) window.toArray()[2]; //get the third window from the set
    driver.switchTo().window(window3);
    System.out.println(driver.getTitle());
    driver.manage().window().maximize();