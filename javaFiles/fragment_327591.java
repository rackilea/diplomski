public class logoutMenu {
    public static void run(WebDriver driver) {
        Properties prop = new Properties();
        InputStream selectproductsidebarobjectrepository;
        try {
            selectproductsidebarobjectrepository = new FileInputStream(
                    "C:/thisisthepath/ObjectRepositories/SignInPageObjectRepository");
            prop.load(selectproductsidebarobjectrepository);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement logoutNormal = driver.findElement(By.xpath(prop.getProperty("log_out_normal")));
            Actions actions = new Actions(driver);
            actions.moveToElement(logoutNormal).build().perform();
            WebElement logoutHover = driver.findElement(By.xpath(prop.getProperty("log_out_hover")));
            logoutHover.click();
            WebElement logoutPushed = driver.findElement(By.xpath(prop.getProperty("log_out_pushed")));
            logoutPushed.click();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (selectproductsidebarobjectrepository != null) {
                try {
                    selectproductsidebarobjectrepository.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}