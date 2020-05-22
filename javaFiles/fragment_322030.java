XPath xPath =  XPathFactory.newInstance().newXPath();
NodeList nodeList = (NodeList)xPath.compile("//OBJECT_TYPE[text() = '" + getObjType() + "']/following-sibling::prop[1]/*").evaluate(document, XPathConstants.NODESET);

for (int i = 0; i < nodeList.getLength(); i++)
{
  System.out.println(nodeList.item(i).getNodeName() + " = " + nodeList.item(i).getTextContent());
}