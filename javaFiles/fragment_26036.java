private final Properties prob; // Global field
private final WebDriver driver; // Global field

public Constructor_for_your_class()
{
    prop = new Properties(); // Sets the global field
    FileInputStream fis = new FileInputStream("C:\\Users\\XXXX\\src\\URL.properties");
    prop.load(fis);
    System.setProperty("webdriver.chrome.driver",‌​"C:\\xxxxx\\chromedr‌​iver.exe");
    driver = new ChromeDriver(); // Sets the global field
}

public void openURL()
{
    driver // Accesses the global field
        .get(prop // Accesses the global field
            .getProperty("URL"));
    // ...
}