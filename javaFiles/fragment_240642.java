public class FirstTestNGclass {

    public WebDriver driver;

    @BeforeSuite 
    public void SetDriverPaths()
    {
        // ....
        this.driver = new InternetExplorerDriver();
    }

    // ....

}