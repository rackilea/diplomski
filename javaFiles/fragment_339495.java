public void selectMulti(String[] listItems)
{
    Select select = new Select(driver.findElement(By.id("abc")));

    if (listItems.length > 1 && !select.isMultiple())
    {
        Log.fail("The SELECT is not a multiple select but the list provided is larger than 1.");
        return;
    }

    for (String listItem : listItems)
    {
        try
        {
            select.selectByVisibleText(listItem);
        }
        catch (NoSuchElementException e)
        {
            Log.failed(listItem + " was not an available option");
            e.printStackTrace();
            return;
        }
    }
}