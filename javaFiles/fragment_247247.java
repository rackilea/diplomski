if(displayFlag==true && enableFlag==true)
    {
        try{
        Thread.sleep(5000);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        WebElement element=driver.findElement(By.xpath("//span[@class='radio_state']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        System.out.println("Tried to click One Way");
    }