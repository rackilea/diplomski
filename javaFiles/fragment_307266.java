public String getTagValue(String sTag, org.w3c.dom.Element eElement) {
    Node n = eElement.getElementsByTagName(sTag).item(0);
    if(e !=null) {
        NodeList nlList = n.getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue != null) {
            return nValue.getNodeValue();
        }
    }
    return ""; // or return null; if that is more applicable to the use case
}