class SomeTest {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("key", "value");
        driver = new ChromeDriver();
    }

    public static void a() {

        driver.findElement(By.id("hi"));

    }
}