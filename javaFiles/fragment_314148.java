WebElement selectDropDown=driver.findElement(By.xpath(".//select[@id='level_points']"));
List<WebElement> options=selectDropDown.findElements(By.tagName("option"));
for(int i=0;i<options.size();i++)
{
 try{
    String isDisabled=options.get(i).getAttribute("disabled");
     //Write the required code if disabled
    }
 catch(Exception ex)
   {
    //Write required code if not disabled
   } 
}