List<WebElement> scripts = driver.findElements(By.xpath("//script[contains(., 'function(a,b,c,d)')]"));
if (!scripts.isEmpty())
{
    // the script tag with the anonymous function was found
    // do stuff
}