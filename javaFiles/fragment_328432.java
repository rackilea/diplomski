List<WebElement> allEle = driver.findElements(By.cssSelector("[id^='s']"));
String letters[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
foreach (String letter in letters)
{
    allEle = allEle.findElements(By.cssSelector("*:not([id^='s" + letter + "']));
}