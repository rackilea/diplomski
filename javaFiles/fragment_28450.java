public LoginPage(WebDriver driver){
    this.driver = driver;
}
public void typeusername(){
    driver.findElement(username).sendKeys("admin"); 
}