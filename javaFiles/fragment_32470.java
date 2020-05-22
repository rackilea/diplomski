WebDriver driver = new FirefoxDriver();
driver.get("http://www.google.com");
driver.quit();              
if(driver.toString().contains("null"))
{

System.out.print("All Browser windows are closed ");
}
else
{
//open a new Browser
}