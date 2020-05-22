public synchronized WebDriver scrollToBottom(WebDriver driver, WebElement element,int time) throws InterruptedException {
     String oldpage="";
     String newpage="";


     do{
         oldpage=driver.getPageSource();
         ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, (document.body.scrollHeight))");
         this.wait(time);
         newpage=driver.getPageSource();
    }while(!oldpage.equals(newpage));
        return driver;
    }