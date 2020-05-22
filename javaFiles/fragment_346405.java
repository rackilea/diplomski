* Method to retrieve element
     * @param identifier to locate element
     * @param expression value
     * @return WebElement
     */
    public WebElement getElement(Identifier identifier, String expression) {
        By byElement = null;
        switch (identifier) {
        case xpath: {
            byElement = By.xpath(expression);
            break;
        }
        case id: {
            byElement = By.id(expression);
            break;
        }
        case name: {
            byElement = By.name(expression);
            break;
        }
        case classname: {
            byElement = By.className(expression);
            break;
        }
        case css: {
            byElement = By.cssSelector(expression);
            break;
        }
        case linktext: {
            byElement = By.linkText(expression);
            break;
        }
        case paritallinktext: {
            byElement = By.partialLinkText(expression);
            break;
        }
        case tagname: {
            byElement = By.tagName(expression);
            break;
        }
        }
        WebElement query = driver.findElement(byElement);
        return query;
    }