NodeList nodes = (NodeList)result;
    for (int i = 0; i < nodes.getLength(); i++)
    {
        NamedNodeMap a = nodes.item(i).getAttributes();
        for (int j=0; j<a.getLength(); j++)
            System.out.println(a.item(j));
    }