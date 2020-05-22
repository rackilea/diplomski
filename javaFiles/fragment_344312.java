private static IWebDriver driver;

public static void SetDriver(IWebDriver Driver) {
    driver = Driver;
}

public static IWebDriver GetDriver() {
    return driver;
}