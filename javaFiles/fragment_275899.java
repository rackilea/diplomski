private static final Element dummy = new Element(Tag.valueOf("p"), ""); // used for "testparsing"

// ...

public static boolean isValid(String query)
{
    if( query == null ) // Check for null
        return false;

    try
    {
        Selector.select(query, dummy); // Use the querystring on the dummy - returnvalue is not relevant
    }
    catch( Selector.SelectorParseException | IllegalArgumentException ex ) // these exceptions are thrown if something is not ok
    {
        return false; // If something is not ok, the query is invalid
    }

    return true; // All ok, query is valid
}