Node getChild(final NodeList list, final String name)
    {
        for (int i = 0; i < list.getLength(); i++)
        {
            final Node node = list.item(i);
            if (name.equals(node.getNodeName()))
            {
                return node;
            }
        }
        return null;
    }