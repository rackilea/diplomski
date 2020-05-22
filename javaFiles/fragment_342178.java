@BeforeTest
public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.facebook.com";
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@Test
public void testUntitled() throws Exception {
    driver.get(baseUrl + "/login.php");
    driver.findElement(By.id("email")).sendKeys("youridhere@gmail.com");
    driver.findElement(By.id("pass")).sendKeys("yourpassword");
    driver.findElement(By.name("login")).click();
    Thread.sleep(3000);
    WebElement msgframe = driver.findElement(By.id("fbMessagesJewel"));
    msgframe.findElement(By.tagName("a")).click();
    List<WebElement> element = driver.findElements(By
            .className("messagesContent"));
    element.get(0).click();
    WebElement chat = driver.findElement(By.className("fbNubFlyoutFooter"));
    chat.findElement(By.tagName("textarea")).sendKeys("Hi");
    driver.findElement(By.tagName("textarea")).sendKeys(Keys.RETURN);
    Thread.sleep(2000);
}