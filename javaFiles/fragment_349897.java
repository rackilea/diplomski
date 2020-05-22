protected WebElement getVisibleElement(List<WebElement> elements)
{
    //Need a guard clause here to ensure there are exactly two elements,
    //Or make the wait check for all elements more safely. Either way,
    //consider changing the method name to be clear about expectations

    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(
        ExpectedConditions.or(
             //This should be done more safely, unless already guarded to expect 2 elements
             ExpectedConditions.visibilityOf(elements.get(0))),
             ExpectedConditions.visibilityOf(elements.get(1)))
        )
    );

    for (WebElement element : elements) {
        if (element.isDisplayed())
        {
            return element;
        }
    }
    //Throw element not visible exception or something
}