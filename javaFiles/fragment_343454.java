String mainwindow = driver.getWindowHandle();        
        driver.findElement(By.xpath(".//*[@id='cas3_lkwgt']/img")).click();//Assuming clicking on this element brings out the new window

        Set<String> s = driver.getWindowHandles(); 
        Iterator<String> ite = s.iterator(); 
        while(ite.hasNext()) 
        { 
            String popup = ite.next(); 
            if(!popup.equalsIgnoreCase(mainwindow)){ 
                driver.switchTo().window(popup); 
                break;
              }
        }