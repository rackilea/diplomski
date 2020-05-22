public static void main(String[] args) throws JDOMException, IOException {
    File xmlFile = new File("sample.xml");
    SAXBuilder builder = new SAXBuilder();
    Document build = builder.build(xmlFile);        
    XPath filterXpression = XPath.newInstance("//srv:ItemCost");
    System.out.println(filterXpression.getXPath());
    List nodes = filterXpression.selectNodes(build);        
    System.out.println(nodes.size());
}