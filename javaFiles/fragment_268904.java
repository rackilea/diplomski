XPathExpression expr = xpath.compile("//TOC//SSIFlds/Fld970");
//evaluate expression result on XML document
NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

for (int i = 0; i < nodes.getLength(); i++) {
    Element node = (Element)nodes.item(i);
    String l = getChildValue(node, "l"), 
           t = getChildValue(node, "t"), 
           p = getChildValue(node, "p");

    // use l, t, and p as needed
}

// defined elsewhere
private static String getChildValue(Element parent, String childName) {
    NodeList nodes = parent.getElementsByTagName(childName);
    return nodes.getLength() > 0 ? nodes.item(0).getTextContent() : "";
}