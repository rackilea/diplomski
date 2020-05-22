// between step 4 and step 5
// remove selenium.selectFrame("relative=up");
driver.switchTo().defaultContent(); // you are now outside both frames
driver.switchTo().frame("cq-cf-frame");
// now continue step 6
driver.findElement(By.xpath("//button[text()='OK']")).click();