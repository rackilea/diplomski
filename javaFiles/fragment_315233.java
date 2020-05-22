int j = 0;
for(int i = 0; i < tags.length; i++)
{
    String content = childNodes.item(i).getNodeName().trim().replaceAll("\\s", "");

    if(childNodes.item(i).getNodeType() == Node.ELEMENT_NODE &&
        childNodes.item(i).getNodeName() != null)
    {
        tags[j++] = content;
    }
}