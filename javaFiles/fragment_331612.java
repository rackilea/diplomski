public static List<WebElement> findElementsUsingHtmlXpathClass(WebDriver driver, String htmlElement,
        String className) {
    List<WebElement> elements = driver
            .findElements(By.xpath("//" + htmlElement + "[contains(@class, '" + className + "')]/following-sibling::div[@class='trinity-right-widget']/descendant::div[contains(@class,'switch-active')]"));
    return elements;
}