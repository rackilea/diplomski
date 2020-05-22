public void testWithChrome(){
    WebDriver driver =  new ChromeDriver(DesiredCapabilities.chrome());
    testSuite(driver);
    driver.close();
    try {
        driver.quit();
    }catch(Exception e){
        System.out.println("Driver error preventing from Quitting.");
    }
}

@Test
public void testWithFirefox(){
    WebDriver driver = new FirefoxDriver(DesiredCapabilities.firefox());
    testSuite(driver);
    driver.close();
    try {
        driver.quit();
    }catch(Exception e){
        System.out.println("Driver error preventing from Quitting.");
    }
}

public void testSuite(WebDriver driver){
    driver.navigate().to("http://localhost:8000/web/");
    Assert.assertTrue("title should start with Polymer Todo App",
            driver.getTitle().startsWith("Polymer Todo App"));

    System.out.printf("This is a Test: '%s'\n", driver.getTitle());
    System.out.println(driver.getTitle().startsWith("Polymer Todo App"));
}