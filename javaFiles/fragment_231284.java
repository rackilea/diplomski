// pseudo Java code with the same logic
public static List<WebElement> findDisplayedElements(WebDriver driver, By locator) {
    List <WebElement> elementOptions = driver.findElements(locator);
    List <WebElement> displayedOptions = new List<WebElement>();
    for (WebElement option : elementOptions) {
        if (option.isDisplayed()) {
            displayedOptions.add(option);
        }
    }
    return displayedOptions;
}