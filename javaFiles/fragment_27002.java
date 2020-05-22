public static void main(String args[]) throws Exception {
    SAXBuilder builder = new SAXBuilder();
    Document d = builder.build("xpath.xml");
    XPath xpath = XPath.newInstance("x:collection/x:dvd");
    xpath.addNamespace("x", d.getRootElement().getNamespaceURI());
    System.out.println(xpath.selectNodes(d));
}