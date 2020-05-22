for(int year = 1900; year <= 2012; year++){
if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
driver.findElement(By.id("DOB")).clear();
driver.findElement(By.id("DOB")).sendKeys("29/02/" + year);
}
}