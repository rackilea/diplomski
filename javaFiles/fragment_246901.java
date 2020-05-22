public class CheckLinks
{
    public static void main(String[] args) throws UnsupportedFlavorException, IOException
    {
        String firefoxDriverPath = "C:\\Users\\Jeff\\Desktop\\branches\\Selenium\\lib\\geckodriver-v0.11.1-win32\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String baseUrl = "http://newtours.demoaut.com/";
        driver.get(baseUrl);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> hrefs = new ArrayList<>();
        for (WebElement link : links)
        {
            hrefs.add(link.getAttribute("href"));
        }
        System.out.println(hrefs.size());
        String underConsTitle = "Under Construction: Mercury Tours";
        for (String href : hrefs)
        {
            driver.get(href);
            System.out.print("\"" + href + "\"");
            if (driver.getTitle().equals(underConsTitle))
            {
                System.out.println(" is under construction.");
            }
            else
            {
                System.out.println(" is working.");
            }
        }
        driver.close();
        driver.quit();
    }
}