else if (firstLine.contains("QUIT"))
{
    for (OutputQuery query : queries)
    {
        Person p = getPerson(query.name);

        if (query.command == "ANCESTORS")
        {
            printAncestor(p);
        } else if (query.command == "DESCENDANTS")
        {
            printDescendant(p);
        }
    }

    System.exit(0);
}