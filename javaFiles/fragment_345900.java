driver.get("file:///C:/Users/Jainish.M.Kapadia/Desktop/aaa.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

driver.findElement(By.id("inputEmail")).sendKeys("test@gmail.com");

WebDriverWait wait = new WebDriverWait(driver, 7);
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='passwordRadios1']"))));

WebElement no = driver.findElement(By.xpath("//input[@id='passwordRadios1']"));
if(!no.isSelected())
{
    no.click();
}