List <WebElement> fistPagelist = driver.findElements(By.xpath("//div[@class='tjlms-tbl']/table/tbody/tr"));
    total = fistPagelist .size();
boolean hasNextPage=true;

    while(hasNextPage)
    {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        List <WebElement> disabledButtonList = driver.findElements(By.xpath("//li[@class='disabled']//span[@class='icon-forward icon-last']"));

        //If the page is lastpage, then only above disabledButtonList webElement will be found and it's size will be 1. Otherwise, it's size will be 0.

        if(disabledButtonList.size()==0){
            driver.findElement(By.className("icon-next")).click();
            List <WebElement> itemlist = driver.findElements(By.xpath("//div[@class='tjlms-tbl']/table/tbody/tr"));
            total = total + itemlist.size();
            //Inorder to iterate the while loop, hasNextPage flag value is set it as true
            hasNextPage=true;           
        }
        else{
             List <WebElement> itemlist = driver.findElements(By.xpath("//div[@class='tjlms-tbl']/table/tbody/tr"));
             total = total + itemlist.size();
            //If the LastPage found, then we need to stop the while loop and hence hasNextPage flag value is set it as false;
            hasNextPage=false;  
            System.out.println("You have reached the last page");
        }           
    }