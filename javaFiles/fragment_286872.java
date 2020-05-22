public class PG1 {


    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","/Users/home/Downloads/geckodriver");
        FirefoxOptions fxProfile = new FirefoxOptions();
        fxProfile.setHeadless(true);
        fxProfile.addPreference("browser.download.folderList",2);
        fxProfile.addPreference("browser.download.manager.showWhenStarting",false);
        fxProfile.addPreference("browser.download.dir","/Users/home/Downloads/");
        fxProfile.addPreference("browser.helperApps.neverAsk.saveToDisk","image/png");
        driver = new FirefoxDriver(fxProfile);
        String baseUrl = "http://rowanwins.github.io/leaflet-easyPrint/";
        driver.get(baseUrl);
        while(checkForPresenceOfElementByXpath("")) {
        }
        System.out.println("Loaded");
        driver.findElement(By.xpath("/html/body/button")).click();
        while(checkForPresenceOfElementByXpath("")) {
        }
        System.out.println("Downloaded");
        driver.close();
    }

    public static boolean checkForPresenceOfElementByXpath(String xpath){
        try{
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(xpath)[last()]")));
            return true;
        }catch(Exception e){
            return false;
        }
    }
}