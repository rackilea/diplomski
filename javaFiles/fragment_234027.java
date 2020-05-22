WebElement deliveredChartDailyFocus = driver.findElement(By.id("delivered-chart-daily"));
deliveredChartDailyFocus.click();

// Get a list of all the <rect> elements under the #delivered-chart-daily element
List<WebElement> children = deliveredChartDailyFocus.findElements(By.tagName("rect"));

WebElement elementToClick = null; // variable for the element we want to click on
for (WebElement we : children)    // loop through all our <rect> elements
{
    if (we.isDisplayed())
    {
        elementToClick = we;      // save the <rect> element to our variable
        break;                    // stop iterating
    }
}

if (elementToClick != null)       // check we have a visible <rect> element
{
    elementToClick.click();
}
else
{
    // Handle case if no displayed rect elements were found
}