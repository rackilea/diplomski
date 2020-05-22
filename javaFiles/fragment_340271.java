int currentHeight = 1;
int lastHeight = 0;
boolean endOfPage = false;
while (!isElementPresent(locator) && !endOfPage)
{
    currentHeight = scrollDown();
    endOfPage = currentHeight == lastHeight;
}
if (!endOfPage)
{
    // do something with the desired element
}
else
{
    // log error that the element was not found before reaching end of page
}