public WebElement getFirstVisibleElement(List<WebELement> elements) {
    for (WebElement ele : elements)
        if (ele.isEnabled() && ele.isDisplayed())
            return ele;
    return null;
}