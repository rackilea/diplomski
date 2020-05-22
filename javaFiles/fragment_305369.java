public final static String getElementValue( Node elem ) {
    if ((elem == null) || (!(elem.hasChildNodes())))
        return "";

    Node kid;
    StringBuilder builder = new StringBuilder();
    for(kid = elem.getFirstChild(); kid != null; kid = kid.getNextSibling())
    {
        if( kid.getNodeType() == Node.TEXT_NODE  )
        {
            builder.append(kid.getNodeValue());
        }
    }
    return builder.toString();
}