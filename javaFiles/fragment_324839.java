public static String addSpaces (String string, int desiredLength)
{
    String [] parts = string.trim ().split ("\\s+");

    int l = parts.length;

    if (l <= 1)
        return string; // Cannot add spaces because there is only one word
    else
    {
        int count = 0;
        for (String part: parts)
            count += part.length ();

        count = desiredLength - count;

        if (count < 0) count = 0;

        int n = count / (l - 1);
        int k = count % (l - 1);

        StringBuilder result = new StringBuilder (parts [0]);
        for (int i = 0; i < l - 1; i++)
        {
            int m = i < k ? n + 1 : n;

            for (int j = 0; j < m; j++)
                result.append (' ');

            result.append (parts [i + 1]);
        }

        return result.toString ();
    }
}

public static void main (String [] args)
{
    System.out.println (addSpaces ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec est ligula, porta", 80));
    System.out.println (addSpaces ("quis feugiat eget, congue ac odio. Curabitur in purus mi, nec feugiat velit. Ut", 80));
    System.out.println (addSpaces ("pulvinar massa vel risus fringilla adipiscing. Aliquam fringilla congue mi, eget", 80));
    System.out.println (addSpaces ("consectetur nibh egestas at. In hac habitasse platea dictumst. Nullam interdum", 80));
    System.out.println (addSpaces ("rutrum laoreet. Etiam vestibulum diam dui. Phasellus erat sapien, pulvinar vel", 80));
    System.out.println (addSpaces ("rutrum eu, accumsan vel ante. Etiam odio erat, commodo eu rutrum eu, molestie id", 80));
    System.out.println (addSpaces ("tellus. Ut eu ante ipsum. Cras pretium bibendum nisi a rhoncus. Lorem ipsum", 80));
    System.out.println (addSpaces ("dolor sit amet, consectetur adipiscing elit. Etiam porta, urna non placerat", 80));
    System.out.println (addSpaces ("rutrum, velit enim aliquet arcu, non vehicula sem mauris non dui. Quisque est", 80));
    System.out.println (addSpaces ("nisi, facilisis non pretium et, luctus in nisi. Ut sed luctus enim. Maecenas", 80));
    System.out.println ("vitae lorem vel justo aliquet consectetur.");
}