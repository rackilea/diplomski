public static List<WebElement> findSubElementsUsingHtmlXpathClass(String htmlElement,
        String className, WebElement parent) {
    String xPathString=".//" + htmlElement + "[contains(@class, '" + className + "')]";

    List<WebElement> elements = parent.findElements(By.xpath(xPathString));
    return elements;
}