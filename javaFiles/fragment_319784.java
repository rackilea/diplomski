WebElement elems=driver.findElement(By.linkText("Custom Development"));//Menu Item
WebElement elems1=driver.findElement(By.xpath("//li[@id='item-465']/a"));//Menu
Actions builder = new Actions(driver); 
Actions hoverOverRegistrar = builder.moveToElement(elems1);
hoverOverRegistrar.perform();
elems.click();//at last Menu Item Click