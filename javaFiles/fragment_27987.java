boolean findPrimary=driver.findElements(By.xpath("//*[@id='started_in_business_view']/p")).size() > 0;
if(findPrimary){
        driver.findElement(By.xpath("//*[@id='started_in_business_view']/p")).click();
    }
    else 
        driver.findElement(By.xpath("//*[@id='started_in_business_view']/div")).click();