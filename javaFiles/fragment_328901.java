/**
 * Retrieves the current state of the DOM tree by executing
 * {@code return document.childNodes[1].outerHTML;} in {@code browser}.
 *
 * @throws TransformerConfigurationException if such an expection occurs
 * during the construction of the parser to read the page source of the
 * {@code browser}
 */
public String retrieveDOMTree(JavascriptExecutor browser) throws TransformerConfigurationException,
        ParserConfigurationException,
        SAXException,
        IOException,
        TransformerException {
    String htmlOuterHtml = (String) browser.executeScript("return document.childNodes[1].outerHTML;");
    return htmlOuterHtml;
}