Node node=nodeListCountry.item(i);
if(node !=null) {
    Element elementMain=(Element) node;

    NodeList nodeListText=elementMain.getElementsByTagName("karikatur");

    Element elementText=(Element) nodeListText.item(0);
    if(elementText!=null) {
        Node n = elementText.getChildNodes().item(0);
        if(n!=null) {
           xmllistesi.add(n.getNodeValue());
        }
    }
}