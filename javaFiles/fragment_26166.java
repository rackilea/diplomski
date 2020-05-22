Thread.sleep(10000);
  WebElement element1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div[5]/div/input"));
  element1.click();
  hread.sleep(20000);
  // Second path
  WebElement element2 = driver.findElement(By.xpath("//*[@id='sbt67Pin']"));
  element2.click();
  // Third path
  Thread.sleep(30000);