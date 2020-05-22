public static void daysInStockSelectContract(InternetExplorerDriver driver) {
    //get the parent handle before clicking on the link 
    String winHandleBefore = driver.getWindowHandle();

    System.out.println("Current handle is: "+winHandleBefore);

    driver.findElement(By.xpath(".//*[@id='page-content']/table/tbody/tr[1]/td[1]/a")).click();

    // Iterating through the set of window handles till the child window's handle, that is infact
    // not equal to the current window handle, is found
    for(String winHandle : driver.getWindowHandles()) {
       if(!winHandle.equals(winHandleBefore)){
                System.out.println("Child handle is: "+ winHandle);
                //Sleeping for 4 seconds for detecting Child window
                try{
                    Thread.sleep(4000);
                   }catch(InterruptedException e){
                    System.out.println("Caught exception related to sleep:"+e.getMessage());
                   }
                driver.switchTo().window(winHandle);
                break;
            }
    } 

    System.out.println("AFTER SWITCHING, Handle is: "+driver.getWindowHandle());

    driver.close();

    //Sleeping for 4 seconds for detecting Parent window
    try{
        Thread.sleep(4000);
       }catch(InterruptedException e){
        System.out.println("Caught exception related to sleep:"+e.getMessage());
       }

    driver.switchTo().window(winHandleBefore); // Switching back to parent window

     System.out.println("NOW THE CURRENT Handle is: "+driver.getWindowHandle());

     //Now perform some user action here with respect to parent window to assert that the window has switched properly


}