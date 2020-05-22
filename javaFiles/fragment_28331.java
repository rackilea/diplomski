WebElement ele = driver.findElement(By.xpath(".//*[@id='responsiveHeader']/div[1]/div[1]/ul/li[4]/ul/li[9]/a")); // Sign Out element 
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true);", ele); // scrolling upto "Sign Out" element.
// Quikr has some problem of scrolling in website - so, we have to again scroll to top.
js.executeScript("scroll(0, 0);");
driver.findElement(By.linkText("Sign Out")).click();