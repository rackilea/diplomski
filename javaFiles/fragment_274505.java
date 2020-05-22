public static void main(String args[]) throws InterruptedException
{

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/recaptcha/api2/demo");

        WebElement frame = driver.findElement(By.xpath(".//iframe[@title='recaptcha widget']"));

        driver.switchTo().frame(frame);

        driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(2000);

        WebElement frame1 = driver.findElement(By.xpath(".//iframe[@title='recaptcha challenge']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click(); // this will click on the [Verify] button.
}