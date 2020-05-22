WebElement element = driver.findElement(By.xpath("/html/body/div/form/div/div/div/div/div[1]/div/div/div")); 
        Actions action = new Actions(driver); action.moveToElement(element).build().perform(); 
    WebElement toolTipElement = driver.findElement(By.xpath("/html/body/div/form/div/div/div/div/div[1]/div/div/div")); if(driver.getPageSource().contains("Hover message")) { System.out.println("Available"); 
    } else
    {
    System.out.println("Not Available"); 
    }