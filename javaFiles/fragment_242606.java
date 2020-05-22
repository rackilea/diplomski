XPath xpath = XPathFactory.newInstance().newXPath();
NodeList nodes = (NodeList) xpath.evaluate(
    "//@*["
        + "local-name()='class'"
        + " or local-name()='id'"
        + " or local-name()='for'"
        + " or local-name()='name'"
    + "]",
    new InputSource(new StringReader(htmlContent)),
    XPathConstants.NODESET);
int count = nodes.getLength();
for (int i = 0; i < count; i++) {
    Collections.addAll(attributes,
        nodes.item(i).getNodeValue().split("\\s+"));
}