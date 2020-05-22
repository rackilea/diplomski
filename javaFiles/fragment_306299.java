String expression = "/root[name='item 2']/reference_id";

NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
for (int i = 0; i < nodeList.getLength(); i++) {
   System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
}