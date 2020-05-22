String OneA = "";
try{
    //find element
    OneA = driver.findElement(By.xpath(actualXpath_1A)).getText();
}catch (NoSuchElementException e){
    //stacktrace and other code after catching the exception
    e.printStackTrace();
}