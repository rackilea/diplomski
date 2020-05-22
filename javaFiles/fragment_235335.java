driver.findElement(By.id("ui-id-3")).click();
             driver.findElement(By.linkText("Info Log")).click();

             driver.findElement(By.id("txtMessage")).sendKeys("Push Success");

             driver.findElement(By.id("txtMachineName")).sendKeys("AC204");

             driver.findElement(By.id("txtPortal")).sendKeys("91");

             driver.findElement(By.id("btnSearch")).click();

            // use it just before the sendkeys code like this 
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dvCount']/span[2]")));
            String text = driver.findElement(By.xpath("//*[@id='dvCount']/span[2]")).getText();
            System.out.println(text);
Hope this helps