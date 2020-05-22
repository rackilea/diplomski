for( int i=0; i<applications.length(); i++) {
    Node node = applications.item(i);
    if(!(node instanceof Element)) continue;
    Element e = (Element) node;
    String id = e.getAttributeNode("id").getValue();
    if("ID2".equals(id)) {
        ... do something with the node ...
    }
}