import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.interactions.Actions;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;

    import java.io.File;
    import java.lang.reflect.Method;
    import java.util.concurrent.TimeUnit;

    public class ITestGroupism {
        WebDriver driver;

        @BeforeTest(groups = {"A", "B"})
        public void setup() {
            System.setProperty("webdriver.chrome.driver", new File("src/test/resources/driver/chromedriver")
                    .getAbsolutePath());
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.google.co.in");
        }

        @Test(dataProvider = "SearchProvider", alwaysRun = true, groups = "A")
        public void testMethodA(String author, String searchKey) throws InterruptedException {
            WebElement searchText = driver.findElement(By.id("sb_ifc0"));
            Actions actions = new Actions(driver);
            actions.moveToElement(searchText);
            actions.click();
            actions.sendKeys(searchKey);
            actions.build().perform();
            System.out.println("Welcome ->" + author + " Your search key is " + searchKey);
            driver.navigate().back();
            driver.navigate().forward();
            System.out.println("thread will sleep now");
            Thread.sleep(2000);
        }

        @Test(dataProvider = "SearchProvider", alwaysRun = true, groups = "A")
        public void testMethodB(String searchKey) throws InterruptedException {
            WebElement searchText = driver.findElement(By.id("sb_ifc0"));
            Actions actions = new Actions(driver);
            actions.moveToElement(searchText);
            actions.click();
            actions.sendKeys(searchKey);
            actions.build().perform();
            //searchText.sendKeys(searchKey);
            System.out.println("Welcome Professor" + "Your search key is " + searchKey);
            driver.navigate().back();
            driver.navigate().forward();
            System.out.println("thread will sleep now");
            Thread.sleep(2000);
        }

        @DataProvider(name = "SearchProvider")
        public Object[][] ff(Method method) {
            Object[][] groupArray = null;
            if (method.getName().equalsIgnoreCase("testMethodA")) {
                groupArray = new Object[][]
                        {
                                {"Aakash", "India"},
                                {"Aayush", "US"},
                                {"Raveena", "UK"}
                        };
            } else if (method.getName().equalsIgnoreCase("testMethodB")) {
                groupArray = new Object[][]
                        {
                                {"Canada"},
                                {"New Zealand"},
                                {"Russia"}
                        };
            }
            return groupArray;
        }
    }