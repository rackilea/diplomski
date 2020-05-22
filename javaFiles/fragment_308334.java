public WebElement fluentWait(final By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
        .ignoring(org.openqa.selenium.NoSuchElementException.class);
        WebElement foo = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                }
        );
        return  foo;              }     ;
fluentWait(By.xpath(....blablabla..)).click();
//fluentWait(By.xpath(....blablabla..)).getText();