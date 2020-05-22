public class Browser {

    public static WebDriver getDriver() {
        String browserType = Properties.getValue("browser.type"); //it will get the `chrome` for profile `chrome`
        switch(browserType) {
            case "chrome": return new ChromeDriver();
        }
    }
}