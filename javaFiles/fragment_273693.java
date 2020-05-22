String requestedName = "AQCB Number"; // sample string for testing
List<WebElement> inputs = driver.findElements(By.cssSelector("input[type='radio']"));
for (WebElement input : inputs)
{
    String onclick = input.getAttribute("onclick");
    String[] parts = onclick.split(",");
    String name = parts[parts.length - 1];
    name = name.substring(1, name.length() - 2);
    System.out.println(name); // for debug purposes
    if (name.equals(requestedName))
    {
        // name match, do stuff here...
    }
}