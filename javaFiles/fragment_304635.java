public String splitfunc(String str)
{
    str = str.replace(".html", "");
    String[] array = str.split("-"); 
    return array[1];
}


  List<WebElement> elements = driver.findElements(By.tagName("a")); 
  for (int i = 0; i < elements.size(); i++) {
   System.out.println(splitfunc(elements.get(i).getAttribute("href")));
}