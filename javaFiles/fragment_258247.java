public static List<String> getStringsInMdSelect(WebElement mdSelect) {
    List<String> selectionStrings = new ArrayList<>();
    WebElement contentElement = mdSelect.findElement(By.tagName("md-content"));
    List<WebElement> contentDivs = contentElement.findElements(By.tagName("div"));

    for (WebElement contentDiv : contentDivs) {
        String rawText = contentDiv.getAttribute("textContent");
        selectionStrings.add(rawText.trim());
    }
    return selectionStrings;
}