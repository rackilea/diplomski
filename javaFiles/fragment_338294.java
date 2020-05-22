Wait<WebDriver> newwait=new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class);

        WebElement combo=newwait.until(new ExpectedCondition<WebElement>(){
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement found = driver.findElement(By.xpath(sXpath));
                if (ExpectedConditions.stalenessOf(found).apply(driver)) {
                    return null;
                }
                return found;
            }

        });