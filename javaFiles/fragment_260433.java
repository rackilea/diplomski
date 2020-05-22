if(!driver.findElements(By.id("ViewErrorMessage")).isEmpty()) {

      String errorMsg = driver.findElement(By.xpath("//*[@id=\"ctl00_pnlViewErrorMessage\"]")).getText();
  Assert.assertEquals(errorMsg, "Form is disabled, Hence you are here. Enable the form");

      //system setting code

      driver.findElement(By.xpath("//input[@name='btnSignin']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//img[@id='imgLogo']")).isDisplayed();
}else{

  //code to verify form elements goes here..
}