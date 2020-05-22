try{
WebElement idYes = driver.findElement(By.id("idYes"));
if (idYes.isElementPresentAndDisplayed())
    ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true",idYes.isElementPresentAndDisplayed());

    idYes.click();

}catch(org.openqa.selenium.NoSuchElementException ignore){
        //TODO: do nothing
}