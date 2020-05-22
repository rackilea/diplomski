for(WebElement result:resultsList)
 {
 System.out.println("Name of the 
 product:"+result.findElement(By.tagName("h2")).getText());

 System.out.println("Brand: "+result.findElement(By.xpath(".//*[@class='s-
 item-container']/div[3]/div[2]/span[2]")).getText());

if(result.findElements(By.xpath(".//*[@class='s-item-
container']/div[4]/span/a/i")).size() != 0
&& result.findElement(By.xpath(".//*[@class='s-item-
container']/div[4]/span/a/i")).getText().equals("Lightning Deal"))
{
  String sp =result.findElement(By.xpath(".//*[@class='s-item-
 container']/div[5]/div[1]/a/span[2]")).getText();
  System.out.println("Selling Price: "+sp);       
} 
else
{
    System.out.println("Selling Price:"+result.findElement(By.xpath(".//*
[@class='s-item-container']/div[4]/div[1]/a/span[2]")).getText());
} 
}