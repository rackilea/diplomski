public void traverseNodes(Node node, Vector<Node> nodeList)
{
    if(node.getNodeType() == Node.ELEMENT_NODE)
    {
        nodeList.add(node);
        if(node.getChildNodes().getLength() >= 1)
        {
            NodeList childNodeList = node.getChildNodes();
            for(int nodeIndex = 1;nodeIndex < childNodeList.getLength(); nodeIndex++)
            {
                traverseNodes(childNodeList.item(nodeIndex),nodeList);
            }
        }
    }

}