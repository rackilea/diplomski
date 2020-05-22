public void clearDropdown(WebElement element)
{
    element.findElement(By.cssSelector("[data-qa=icon-x]")).click();
}

// probably needs a better name
public WebElement getChild(WebElement element)
{
    return element.findElement(By.cssSelector(".select__value-container"));
}