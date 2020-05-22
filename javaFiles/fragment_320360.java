WebElement iframe= driver.findElement(By.id("alibaba-login-box"));
    driver.switchTo().frame(iframe);
    WebElement elem = driver.findElement(By.id("fm-login-id"));
    elem.clear();
    elem.sendKeys("asd");

    //when you want to return to the defaultContent
    driver.switchTo().defaultContent();