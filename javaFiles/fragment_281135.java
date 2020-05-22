WebElement inputElement = driver.findElement(By.name("uname"));
JavascriptExecutor js = (JavascriptExecutor) driver;  
boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputElement)
if(isRequired )
{
   //element is required and validation error will popup if the field is empty.
}