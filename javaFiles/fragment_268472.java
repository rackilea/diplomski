WebElement shoeSizes = driver.findElement(By.xpath("//div[contains(@class,'exp-pdp-size-container')]/a"));
shoeSizes.click(); // Expanded
String shoeSize = "8.5";
WebElement shoeSizeSel = driver.findElement(By.xpath("//li[text()='"+shoeSize+"']"));
shoeSizeSel.click(); // Size selected
driver.findElement(By.xpath("//div[@class='exp-pdp-save-container']/button")).click(); // Added to cart