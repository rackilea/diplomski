WebDriver driver = new FirefoxDriver();
String startURL = //a starting url;
String currentURL = null;
WebDriverWait wait = new WebDriverWait(driver, 10);

foo(driver,startURL);

/* go to next page */
if(driver.findElement(By.xpath("//*[@id='someID']")).isDisplayed()){
    String previousURL = driver.getCurrentUrl();
    driver.findElement(By.xpath("//*[@id='someID']")).click();  
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    ExpectedCondition e = new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver d) {
            return (d.getCurrentUrl() != previousURL);
          }
        };

    wait.until(e);
    currentURL = driver.getCurrentUrl();
    System.out.println(currentURL);
}