public MainPage loginAs(String username, String password) 
{       
    driver.get("http://url_to_my_webapp");             
    driver.findElement(By.id("username")).sendKeys(username);     
    driver.findElement(By.id("pwd")).sendKeys(password);     
    driver.findElement(By.className("button")).submit();
    // Add some error checking here for login failure
    return new MainPage(driver);                   
}