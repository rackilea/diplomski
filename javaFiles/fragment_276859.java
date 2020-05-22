List<WebElement> optionsToSelect =  driver.findElements(By.xpath("//div[@id='sugDrp_autoComplete']/ul[@class='Sdrop']/li"));
for (WebElement option : optionsToSelect) {

   WebElement buttonObj = option.findElement(By.tagName("button"))
   if (buttonObj.getText().equals(textToSelect)) {
       System.out.println("Trying to select: "+textToSelect);
       buttonObj .click();
       break;
   }
 }