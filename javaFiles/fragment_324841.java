public static String addSpaces (String [] words, int count)
{
    int l = words.length;

    if (l == 0)
        return "";
    else if (l == 1)
        return words [0];
    else
    {
        int n = count / (l - 1);
        int k = count % (l - 1);

        StringBuilder result = new StringBuilder (words [0]);
        for (int i = 0; i < l - 1; i++)
        {
            result.append(' ');

            int m = i < k ? n + 1 : n;

            for (int j = 0; j < m; j++)
                result.append (' ');

            result.append (words [i + 1]);
        }

        return result.toString ();
    }
}

public static String [] justify (String string, int width)
{
    List<String> result = new ArrayList<String>();

    String [] words = string.trim ().split ("\\s+");

    int n = 0;
    List<String> line = new ArrayList<String>();
    for (String word: words)
    {
        if (!line.isEmpty () && n + word.length () > width)
        {
            result.add (
                addSpaces (
                    line.toArray (
                        new String [line.size ()]), 
                    Math.max (0, width - n)));

            line.clear ();
            n = 0;
        }

        line.add (word);
        if (n > 0)
            n += 1;
        n += word.length();
    }

    result.add (addSpaces (line.toArray (new String [line.size ()]), 0));
    return result.toArray(new String [result.size ()]);
}

public static void main (String [] args)
{
    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut porta bibendum ipsum vitae pretium. Nulla facilisi. Aenean eu orci eget diam bibendum lobortis. Nulla nisl ante, consectetur feugiat tincidunt eget, venenatis a velit. Nullam eget justo pellentesque diam commodo pharetra imperdiet ut tellus. Maecenas massa mi, placerat et vestibulum non, luctus ut nulla. Nam id libero vel massa malesuada commodo vel nec magna. Maecenas faucibus fermentum nisi et mattis.";
    String [] lines = justify (text, 80);
    for (String line: lines)
        System.out.println (line);
}