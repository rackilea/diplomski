String expression = "/Employees/Employee";
NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

for (int i = 0; i < nodeList.getLength(); i++) {
    Node employeeNode = nodeList.item(i);
    String emplId = employeeNode.getAttributes().getNamedItem("emplid").getNodeValue();
}