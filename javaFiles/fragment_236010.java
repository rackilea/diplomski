private String getTagValue(String sTag, Element eElement) {
    NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
            .getChildNodes();

    Node nValue = (Node) nlList.item(0);

    return nValue.getNodeValue();
}