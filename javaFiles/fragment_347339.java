// Renamed method to follow Java naming conventions
public static String findNoun(Parse p)
{    
    for(Parse k : p.getChildren())
    {   
        // Removed a bunch of extraneous brackets, and added whitespace
        // for readability. You should consider a set NOUN_TYPES
        // so you could use if (NOUN_TYPES.contains(k.getType()) instead.
        if (k.getType().equals("NN") || k.getType().equals("NNP") ||
            k.getType().equals("NNS")|| k.getType().equals("NNPS"))
        {
            return k.toString();
        }
        else
        {
            String possibleNoun = findNoun(k);
            // Return immediately if the recursion found a noun
            if (possibleNoun != null)
            {
                return possibleNoun;
            }
        }
    }
    // Nothing found in this node or children: tell the caller
    return null;
}