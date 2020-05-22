WebElement logout = driver.findElement(By.id("dijit_form_Button_0_label"));{

  if(logout.isDisplayed()){
    logout.click();
    Thread.sleep(100);
    logout.click();
}