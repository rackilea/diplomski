import java.util.ArrayList;
import java.util.Iterator;

public class Main
{
    private static final String GUID = "f61916a6-3859-4cda-ae2f-209ff3802831";

    public static void main(String args[])
    {
        // Comma in quotes
        String source = "ADDRESS.CITY || ', UK', ADDRESS.CITY || ', US', ADDRESS.CITY || ', UK', to_char(DATE, '(YYYY)MM,DD'), to_char(DATE, '(YYYY)MM,DD')";
        String expected = "ADDRESS.CITY || ', UK', ADDRESS.CITY || ', US', to_char(DATE, '(YYYY)MM,DD')";
        String result = removeDuplicates(source);
        System.out.println(result.equals(expected));

        // Comma in quotes with escaped single quotes
        source = "ADDRESS.CITY || ', UK''s CITY', ADDRESS.CITY || ', US''s CITY', ADDRESS.CITY || ', UK''s CITY'";
        expected = "ADDRESS.CITY || ', UK''s CITY', ADDRESS.CITY || ', US''s CITY'";
        result = removeDuplicates(source);
        System.out.println(result.equals(expected));

        // Comma in parentheses
        source = "NAME, to_char(DATE, 'YYYY,MM,DD'), to_char(DATE, 'YYYY-MM-DD'), NAME, CITY, to_char(DATE, 'YYYY-MM-DD')";
        expected = "NAME, to_char(DATE, 'YYYY,MM,DD'), to_char(DATE, 'YYYY-MM-DD'), CITY";
        result = removeDuplicates(source);
        System.out.println(result.equals(expected));

        // Comma in parentheses with parentheses
        source = "NAME, to_char(DATE, ('YYYY,MM,DD')), to_char(DATE, 'YYYY-MM-DD'), NAME, CITY, to_char(DATE, 'YYYY-MM-DD')";
        expected = "NAME, to_char(DATE, ('YYYY,MM,DD')), to_char(DATE, 'YYYY-MM-DD'), CITY";
        result = removeDuplicates(source);
        System.out.println(result.equals(expected));

        // Combined
        source = "NAME, to_char(DATE, 'YYYY,MM,DD'), to_char(DATE, ('YYYY-MM-DD')), NAME, to_char(DATE, ('YYYY-MM-DD')), CITY || ', UK', CITY || ', US''s CITY', CITY || ', UK'";
        expected = "NAME, to_char(DATE, 'YYYY,MM,DD'), to_char(DATE, ('YYYY-MM-DD')), CITY || ', UK', CITY || ', US''s CITY'";
        result = removeDuplicates(source);
        System.out.println(result.equals(expected));
    }

    private static String removeDuplicates(String source)
    {
        // Replace escaped quotes with a GUID to make it easier to parse
        source = source.replace("''", GUID);

        source = source + ','; // Hacky way to get the last part to show up

        ArrayList<String> elements = new ArrayList<String>();

        ArrayList<Character> charArray = new ArrayList<Character>();

        for (char c : source.toCharArray())
            charArray.add(c);

        Iterator<Character> itr = charArray.iterator();

        // Identify all the elements
        String thusFar = "";
        while (itr.hasNext())
        {
            char next = itr.next();

            if (next == ',')
            {
                thusFar = thusFar.trim();
                if (!elements.contains(thusFar))
                    elements.add(thusFar);
                thusFar = "";
                continue;
            }

            thusFar += next;

            // Ignore anything inside quotes
            if (next == '\'')
            {
                char c;
                while ((c = itr.next()) != '\'')
                {
                    thusFar += c;
                }
                thusFar += c;
                continue;
            }

            // Ignore anything inside parentheses
            if (next == '(')
            {
                while (true)
                {
                    char c = itr.next();
                    thusFar += c;

                    if (c == ')')
                        break;

                    // Ignore anything inside quotes inside parentheses (including a close paren)
                    if (c == '\'')
                    {
                        char c2 = itr.next();
                        while (c2 != '\'')
                        {
                            thusFar += c2;
                            c2 = itr.next();
                        }
                        thusFar += c2;
                    }
                }

                continue;
            }
        }

        // Combine all the elements back together
        String result = "";

        for (String s : elements)
            result += s + ", ";

        if (result.length() > 2)
        {
            result = result.substring(0, result.length() - 2);
        }

        // Put the escaped quotes back in
        result = result.replace(GUID, "''");

        return result;
    }
}