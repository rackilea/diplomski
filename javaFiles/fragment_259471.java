int index = 0; 

for(WebElement elements: orders){
    index++;
   if(elements.text.equals("#1968"){
       //Here you can click on the link or do whatever... 
this.getDriver().findElement(By.xpath("/html/body/table/tbody/tr[index]/td[1]/div/a")).click();
 }

}