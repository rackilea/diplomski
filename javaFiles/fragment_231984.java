try {
    WebElement submitbuttonPresence=driver.findElement(By.id("btnOk"));
    submitbuttonPresence.click();
}
catch (org.openqa.selenium.NoSuchElementException e) {
    System.out.println(driver.getTitle());
}