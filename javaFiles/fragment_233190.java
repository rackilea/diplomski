if(driver.findElements(By.id("ctl00_Content_ulErrorList")).size() > 0){
    Log.error("Warning error is dispayed when it shouldnt be.");
}else{
    //pass
    Log.info("Warning error is not dispayed." ); // The test should pass if element is not found
}