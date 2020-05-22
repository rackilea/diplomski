boolean continueFunc = false;
while (!continueFunc)
    try{
        //my function
        continueFunc = true;
    }
    catch (NoSuchPageException e ){
        Thread.sleep(3600 * 1000);
        System.out.println("Waiting the timer");            
    }
}