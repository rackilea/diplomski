public void SeasonalLinks() throws InterruptedException
{
    By seasonalLinksLocator = By.xpath("//section[@id='seasonallinks']/ul/li/div/a");
    List<WebElement> seasonalLinks = driver.findElements(seasonalLinksLocator);
    System.out.println("Total no.of seasonal Links: " + seasonalLinks.size());
    WebDriverWait wait = new WebDriverWait(driver, 20);
    for (int i = 0; i < seasonalLinks.size(); i++)
    {
        String seasonalLinkText = seasonalLinks.get(i).getText();
        seasonalLinks.get(i).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='nav-home']/a[@aria-label='home button']"))).click();
        if (seasonalLinkText.equalsIgnoreCase("Use pharmacy self-service tools"))
        {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='acc-spinner-container]")));
        }
        seasonalLinks = driver.findElements(seasonalLinksLocator);
    }
}