List<WebElement> dialogButtons = driver.findElements(By.xpath("//td[starts-with(@id, 'ErrorDialog_button') and text()='OK']"));
System.out.println(dialogButtons.size());
System.out.println(dialogButtons.size());
for (WebElement dialogButton : dialogButtons)
{
    try
    {
        dialogButton.click();
    }
    catch (WebDriverException e)
    {
        // do nothing
    }
}