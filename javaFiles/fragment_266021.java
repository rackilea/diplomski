expr = xpath.compile("//Product/Test");
nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < nodes.getLength(); i++)
{
    Node node = nodes.item(i);
    System.out.println(node.getParentNode().getAttributes().getNamedItem("id"));
    System.out.println(node.getTextContent());
}
System.out.println(nodes.getLength());