WebElement element = (new WebDriverWait(driver, 20))
         .until(newExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return driver.findElement(By.name("q"));
        }
    });