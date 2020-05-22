List<WebElement> all_pages = 
driver.findElements(By.xpath("//form[@id='vContactsForm']/descendant::div[1]/a"));

    int sizeosallpages = all_pages.size();

    for(int i=2;i<=sizeosallpages;i++)
    {

        driver.findElement(By.xpath("//form[@id='vContactsForm']/descendant::div[1]/a["+i+"]")).click();
        Thread.sleep(3000);



        if(driver.getPageSource().contains("nnn jhjhjk"))
        {

            driver.findElement(By.xpath("//a[contains(text(),'nnn jhjhjk')]/parent::*/preceding-sibling::*/child::*")).click();
            Thread.sleep(3000);
            break;
        }


    }