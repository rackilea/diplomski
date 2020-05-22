String expression = "./employees/employee[name='"+ val +"']";
NodeList elements = (NodeList) xPath.evaluate(expression, doc, XPathConstants.NODESET);
for (int i = 0; i < elements.getLength(); i++)
{  
  Node node = elements.item(i);
  Node surname = (Node) xPath.evaluate("surname", node, XPathConstants.NODE);
  Node age = (Node) xPath.evaluate("age", node, XPathConstants.NODE);
  System.out.println(surname.getTextContent() + " " + age.getTextContent() );
} // end for i