List<WebElement> a= driver.findElements(By.xpath(".//*[@id='eviceSliderbuttonPrev']/a"));

if(a.size() > 0 && a.get(0).isDisplayed())
{
   System.out.println("Device Slider button exists");
   a.get(0).click();
   System.out.println("Button is clickable");
 }else {
   System.out.println("Device Slider button doesn't exist!");
 }