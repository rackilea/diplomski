static Map<String, WebDriver> driverMap = new HashMap<String,WebDriver>();

@BeforeClass
public static void initDriverMap(){
    driverMap.put("chrome", new ChromeDriver(DesiredCapabilities.chrome()));
    driverMap.put("firefox", new FirefoxDriver(DesiredCapabilities.firefox()));
}

@AfterClass
public static void cleanUp(){

    Iterator it = driverMap.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String,WebDriver> pair = (Map.Entry)it.next();
        pair.getValue().close();
        try {
            pair.getValue().quit();
        }catch(Exception e){}
    }
}

@Test
public void testWithChrome(){
    WebDriver driver = driverMap.get("chrome");
    testSuite(driver);
}

@Test
public void testWithFirefox(){
    WebDriver driver = driverMap.get("firefox");
    testSuite(driver);
}

public void testSuite(WebDriver driver){
    driver.navigate().to("http://localhost:8000/web/");
    Assert.assertTrue("title should start with Polymer Todo App",
            driver.getTitle().startsWith("Polymer Todo App"));

    System.out.printf("This is a Test: '%s'\n", driver.getTitle());
    System.out.println(driver.getTitle().startsWith("Polymer Todo App"));