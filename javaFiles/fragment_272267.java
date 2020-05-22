/**
 * Method returns By.
 * 
 * @param String identifier Example: xpath,id,name etc
 * @param String expression Example: //*[@class='text']
 * @return By
 */
public By getBy(String identifier, String expression){
    switch (identifier.toLowerCase()) {
    case "xpath":
        return By.xpath(expression);
    case "id":
        return By.id(expression);
    case "name":
        return By.name(expression);
    case "classname":
        return By.className(expression);
    case "cssselector":
        return By.cssSelector(expression);
    case "linktext":
        return By.linkText(expression);
    case "partiallinktext":
        return By.partialLinkText(expression);
    case "tagname":
        return By.tagName(expression);
    default:
        throw new RuntimeException("Invalid identifier passed: " + identifier);
    }
}