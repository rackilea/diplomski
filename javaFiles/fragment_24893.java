setText(WebElements.TEXT_BOX, PASSWORD);
WebDriverWait wait = new WebDriverWait(driver,10);

try{

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id of the element to be located")));
    return SUCCESS;
}
catch (NoSuchElementException exception)
{
    return FAILURE;
}