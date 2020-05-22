public class AutoTest{

public static WebDriver autoDriver;

public AutoTest(){

    autoDriver = new FirefoxDriver();
    autoDriver.get("https://launch.stellar.org/#/login");

}

public void login(String username, String password) throws InterruptedException{

    autoDriver.findElement(By.id("username")).sendKeys(username);
    autoDriver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(1000);
    autoDriver.findElement(By.xpath("//button[.='Log in']")).click();


}

public void faceBookStellar() throws InterruptedException{

    WebElement facebookButon = new WebDriverWait(autoDriver, 10)
    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Receive your first stellars on us!']")));
    facebookButon.click();


}

public void quiteBrowser(){

    autoDriver.close();
    autoDriver.quit();
}

public static void main(String[]args) throws InterruptedException{

    AutoTest testObject = new AutoTest();
    testObject.login("autoStellarTester", "password");
    testObject.faceBookStellar();

}