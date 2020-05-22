List<WebElement> campaignTable = driver.findElements(By.xpath(".//*[@id='campaignAllAvailableList']/li/div"));  
for (WebElement el : campaignTable)
{
    String metadataTitle = el.findElement(By.xpath(".//div/h3")).getText();

    if (target.compareTo(metadataTitle)==0)
    {
        WebElement getStartedButton = el.findElement(By.xpath(".//div[3]/a"));
        getStartedButton.click();
        break;
    }
}``