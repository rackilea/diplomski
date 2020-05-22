boolean isElement1Present = true;

try{       
      driver.findElement(By.xpath("xpathExpression1"));    
}catch (NoSuchElementException e){
    isElement1Present = false;
}

if(isElement1Present == false)
     driver.findElement(By.xpath("xpathExpression2"));