private static List<OutputQuery>    queries = new LinkedList<>();

// ...

else if (firstLine.contains("ANCESTORS"))
{
    String name = splitted[0].substring(10);

    queries.add(new OutputQuery("ANCESTORS", name));

    //...

else if (firstLine.contains("DESCENDANTS"))
{
    String name = splitted[0].substring(12);

    queries.add(new OutputQuery("DESCENDANTS", name));

    //...

else if (firstLine.contains("QUIT"))
{
    for (OutputQuery query : queries)
    {
        if (query.command == "ANCESTORS")
        {
            // Print output
        } else if (query.command == "DESCENDANTS")
        {
            // Print output
        }
    }

//...