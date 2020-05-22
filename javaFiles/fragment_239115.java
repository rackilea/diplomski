public WebElement getFirstVisibleElement(List<WebELement> elements) {
    for (WebElement ele : elements)
        if (ele.isEnabled() && ele.getSize().getHeight() > 0 && ele.getSize().getWidth() > 0 )
            return ele;
    return null;
}