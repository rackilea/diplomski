WebDriverWait wait=new WebDriverWait(driver, 90);
driver=wait.untill(ExpectedConditions.frameToBeAvailableAndSwitchToIt("previewFrame");

WebElement element=driver.findElement(By.TagName("em"));
String fontStyle=element.getCssValue("font-sytle");
System.out.println(fontStyle);