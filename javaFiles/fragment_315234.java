public String[] getAvailableTags() throws Exception
{
    String path = "/docusign-cfg/tagConfig/tags";
    XPathFactory f = XPathFactory.newInstance();
    XPath x = f.newXPath();
    Object result = null;
    try 
    {
        XPathExpression expr = x.compile(path);
        result = expr.evaluate(doc, XPathConstants.NODE);
    } 
    catch (XPathExpressionException e) 
    {
        throw new Exception("An error ocurred while trying to retrieve the tags");
    }

    Node node = (Node) result;
    NodeList childNodes = node.getChildNodes();
    List<String> tags = new ArrayList<String>();
    for(int i = 0; i < tags.length; i++)
    {
        String content = childNodes.item(i).getNodeName().trim().replaceAll("\\s", "");

        if(childNodes.item(i).getNodeType() == Node.ELEMENT_NODE &&
            childNodes.item(i).getNodeName() != null)
        {
            tags.add(content);
        }
    }

    String[] tagsArray = tags.toArray(new String[tags.size()]);
    return tagsArray;
}