foreach(WebElement element in elements)
{
    try{
         var className = element.getAttribute("class");
       }
    catch(Exception e)
       {
         //do whatever you want to do with elements which have no class in them
       }
}