public class youtubeTest
{
    // do no change any of the below
    private String testUrl = "https://www.youtube.com"; // target url destination ie youtube
    private WebDriver driver; // webdriver instance to reference within class

    private By trendingGuideLinkLocator = By.cssSelector("#trending-guide-item");
    private By trendingLinkLocator = By.xpath("//h2[contains(.,'Trending')]");

    @Before
    public void beforeTest()
    {
        System.out.println("Setting up Test..."); // if you are going to have this statement, put it at the start of beforeTest()
        driver = new SafariDriver();
        driver.get(testUrl);
        System.out.println("Set Driver " + driver + "for url: " + testUrl);
    }

    @Test
    public void Test()
    {
        // insert unit tests within here
        driver.findElement(trendingLinkLocator).click(); // just click the Trending link, it's faster
        driver.findElements(trendingGuideLinkLocator).get(3).click();
    }

    @After
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }
}