/**
 * Get the innerText from an element.
 * @param driver    the WebDriver
 * @param element   the element to get innerText from
 * @return  the element's innerText
 */
public static String getInnerText(WebDriver driver, WebElement element) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    return (String) executor.executeScript("return arguments[0].innerText", element);
}