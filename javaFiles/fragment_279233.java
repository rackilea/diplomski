// click the logout button

// click the cancel button

List<WebElement> button = driver.findElements(By.id("sampleId")); // a button on the confirm popup
if (button.isEmpty())
{
    // the logout confirmation popup is not visible

    // verify that you are still logged in... maybe look for a user name or ???
}
else
{
    // log a failure here because you couldn't cancel the logout popup
}