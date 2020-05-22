driver.get("http://www.imdb.com");
    new WebDriverWait(driver, 5000)
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("navTitleMenu")));
    new Actions(driver)
            .clickAndHold(driver.findElement(By.id("navTitleMenu")))
            .moveToElement(driver.findElement(By.linkText("Top Rated Movies")))
            .click()
            .build().perform();