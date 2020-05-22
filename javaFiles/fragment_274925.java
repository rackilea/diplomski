XPathFactory xpathFactory = XPathFactory.newInstance();
// XPath to find empty text nodes.
XPathExpression xpathExp = xpathFactory.newXPath().compile(
        "//text()[normalize-space(.) = '']");  
NodeList emptyTextNodes = (NodeList) 
        xpathExp.evaluate(doc, XPathConstants.NODESET);

// Remove each empty text node from document.
for (int i = 0; i < emptyTextNodes.getLength(); i++) {
    Node emptyTextNode = emptyTextNodes.item(i);
    emptyTextNode.getParentNode().removeChild(emptyTextNode);
}