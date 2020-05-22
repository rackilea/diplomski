Element elem = (Element) childNode;
NodeList assetNodes = elem.getElementsByTagName("asset");
if(assetNodes.getLength() > 0) {
    // get the text content of the first node
    String asset = assetNodes.item(0).getTextContent();
    ...
}