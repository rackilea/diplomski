driver.findElement(By.xpath("//*[@id="btnLogin"]")).click();  
         if(driver.findElements(By.xpath("/html/body/div/form/div/div/span")).size()==1){
          System.out.println("Invalid");       
            }
         else {
          System.out.println("Login Passed"); 
        }