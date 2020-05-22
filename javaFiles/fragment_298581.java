public String getVisibleTextFromElement(WebElement elem)
{
    String visibleText= (String) getJavaScriptExecutor().executeScript("var clone = $(arguments[0]).clone();"
            + "clone.appendTo('body').find(':hidden').remove();"
            + "var text = clone.text();"
            + "clone.remove(); return text;", elem);
    visibleText=visibleText.replaceAll("\\s+", " ");
    return visibleText;
}