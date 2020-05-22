input.findElements(By.xpath("//xpath")).size() > 0


driver.findElement(By.cssSelector(html>blablabla....)).isDisplayed()

public bool IsElementPresent(By selector)
{
    return driver.FindElements(selector).Any();
}