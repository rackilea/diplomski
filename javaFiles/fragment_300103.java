List<WebElement> dialogButtons = driver.findElements(By.cssSelector("div.DwtDialog > td.ZWidgetTitle"));
for (WebElement dialogButton : dialogButtons)
{
    if (dialogButton.isDisplayed() && dialogButton.getText().equals("OK"))
    {
        dialogButton.click();
        break;
    }
}