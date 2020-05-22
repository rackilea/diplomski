driver.findElement(By.xpath("//*[@id="btnLogin"]")).click();  

try{

if(driver.findElement(By.xpath("/html/body/div/form/div/div/span")).isDisplayed())
{
  System.out.println("Invalid");  
}

else{
System.out.println("Valid");  
}

catch(Exception e){
System.out.println("in exception");  
}