NodeList nodeList = (NodeList) xPath.
             compile(search).evaluate(doc, XPathConstants.NODESET);

Node attrNode = nodeList.item(0);
if(attrNode.getNodeType() == Node.ATTRIBUTE_NODE) {
    Attr attr = (Attr) attrNode;

    Element bookElement = attr.getOwnerElement();
    ...
}