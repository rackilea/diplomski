public class MainPage 
{ 
  private final WebDriver driver;  

  public MainPage(WebDriver driver) 
  {     
    this.driver = driver;  
  }   

  public void doSomething() 
  {      
    driver.findElement(By.id("something")).Click;     
  }
}