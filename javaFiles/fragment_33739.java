public static void setOrigin(String origin)
{
    WebElement e = driver.findElement(By.id("flights-origin-prepop-whitelabel_en"));
    e.click();
    e.clear();
    e.sendKeys(origin);
    e.sendKeys(Keys.TAB);
}

public static void setDestination(String dest)
{
    WebElement e = driver.findElement(By.id("flights-destination-prepop-whitelabel_en"));
    e.click();
    e.clear();
    e.sendKeys(dest);
    e.sendKeys(Keys.TAB);
}