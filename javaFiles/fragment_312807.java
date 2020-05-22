public class SampleUITest extends SeleneseTestBase {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://www.blueshieldca.com/fap/app/search.html");

            driver.findElement(By.id("location"))
                    .sendKeys("Locans, Fresno, CA");
            driver.findElement(By.className("findNow")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("continueBtn")).click();
            Thread.sleep(15000);
            driver.findElement(
                    By.xpath("//ul[@id='doctortypesmodule']/li[2]/input"))
                    .click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}