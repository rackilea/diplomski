@Test
public void testFluentWait(){

    driver = new ChromeDriver();
    driver.get("https://www.facebook.com/");
    WebElement element = driver.findElement(By.name("websubmit"));

    waitUntilElementHasText(element);

    //If you are using Java 8
    waitUntilCondition(() -> element.getAttribute("type").contains("submit"));

}

//Only if you are using Java 8
public boolean waitUntilCondition(Callable<Boolean> condition){

    Wait wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);


    wait.until(new Function<WebDriver, Boolean>() {
        public Boolean apply(WebDriver driver) {
            try {
                return condition.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    });

    return false;
}

public boolean waitUntilElementHasText(final WebElement element){

    Wait wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);


    wait.until(new Function<WebDriver, Boolean>() {
        public Boolean apply(WebDriver driver) {
            return element.getText().length() > 0;
        }
    });

    return element.getText().length() > 0;
}