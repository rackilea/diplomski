@Before
public void openGoogle()
{
    System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
    wd = new FirefoxDriver();
    urll = "https://google.com";
}