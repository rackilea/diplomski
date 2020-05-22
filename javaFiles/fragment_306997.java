NodeList childNodes = nodeGettingChanged.getChildNodes();
for (int i = 0; i != childNodes.getLength(); ++i)
{
    Node child = childNodes.item(i);
    if (!(child instanceof Element))
        continue;

    if (child.getNodeName().equals("name"))
        child.getFirstChild().setNodeValue("SomethingElse") ;
    else if (child.getNodeName().equals("ip"))
        child.getFirstChild().setNodeValue("localHost") ;
    else if (child.getNodeName().equals("port"))
        child.getFirstChild().setNodeValue("4447") ;
}