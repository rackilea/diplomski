List<WebElement> els = driver.findElements(By.cssSelector("input[value='Complexity of job requires extra charge']"));
for(WebElement el : els) 
{
  if(el.isDisplayed() && el.isEnabled())
  {
   el.click();
  }
}