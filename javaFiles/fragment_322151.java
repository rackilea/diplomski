By addItemLocator = By.id("HEADING");
By thumbnailsLocator = By.className("thumbnail");
List<WebElement> links = driver.findElements(thumbnailsLocator);
String originalTab = driver.getWindowHandle();
Set<String> tabs = driver.getWindowHandles();
WebDriverWait wait = new WebDriverWait(driver, 10);

for(int i = 0; i < links.size(); i++)
{
    links = driver.findElements(thumbnailsLocator); // this step is must, because whenever you go to other page all store WebElements in a list will wash out
    links.get(i).click();

    // it opens the search result in a new tab and gains focus on that tab

    // switch to the new window
    for(String handle : driver.getWindowHandles()){
        if (!handle.equals(originalTab))
        {
            driver.switchTo().window(handle);
            break;
        }
    }

    // get the "Add Item" element
    List<WebElement> addItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addItemLocator));

    if(!addItems.isEmpty())
    {
        System.out.println(addItems.get(0).getText());
    }
    else
    {
        System.out.println("Title is missing");
    }

    driver.close(); // close current tab
    driver.switchTo().window(originalTab); // switch to original tab
}