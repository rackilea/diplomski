public boolean isAlertPresent(){
    try{
        driver.switchTo().alert();
        return true;
    }catch (NoAlertPresentException e){
        return false;
    }
}