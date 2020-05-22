//Sending blank to the industry dropdown so the list is visible
    driver.findElement(By.xpath("//input[@id='cjaInd']")).sendKeys("");

    Actions act = new Actions(driver);

    //Selecting the checkbox containing text exactly as "Accounting , Finance"
    act.moveToElement(driver.findElement(By.xpath("//div[@id='indCja']//ul[@class='ChkboxEnb']//a[.='Accounting , Finance']"))).click().perform();

    //Selecting the checkbox containing text exactly as 'Strategy , Management Consulting Firms' 
    act.moveToElement(driver.findElement(By.xpath("//div[@id='indCja']//ul[@class='ChkboxEnb']//a[.='Strategy , Management Consulting Firms']"))).click().perform();

    //For clicking outside so as the dropdown closes and we can proceed with other action(s)
    act.moveToElement(driver.findElement(By.xpath("//label[.='Industry']"))).click().perform();

    //Sending blank to the Job Category dropdown so the list is visible
    driver.findElement(By.xpath("//input[@id='cjaJob']")).sendKeys("");

    //Selecting the checkbox containing text exactly as Application Programming, Maintenance
    act.moveToElement(driver.findElement(By.xpath("//div[@id='jcCja']//ul[@class='ChkboxEnb']//a[.='Application Programming, Maintenance']"))).click().perform();

    //Selecting the checkbox containing text exactly as "Site Engineering, Project Management"
    act.moveToElement(driver.findElement(By.xpath("//div[@id='jcCja']//ul[@class='ChkboxEnb']//a[.='Site Engineering, Project Management']"))).click().perform();

    //For clicking outside so as the dropdown closes and we can proceed with other action(s)
    act.moveToElement(driver.findElement(By.xpath("//label[.='Industry']"))).click().perform();