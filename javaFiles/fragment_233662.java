@BeforeClass
public static void setUpClass() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

    Alert javascriptAlert = driver.switchTo().alert();
    System.out.println(javascriptAlert.getText()); // Get text on alert box
    javascriptAlert.accept(); // Chose whether to accept or cancel based on need
}