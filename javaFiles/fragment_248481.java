public class Recur
{
    private static char [] stringToChar (
        String str, char [] destination, int offset)
    {
        if (destination == null)
        {
            destination = new char [str.length ()];
            offset = 0;
        }

        if (offset < str.length ())
        {
            destination [offset] = str.charAt (offset);
            stringToChar (str, destination, offset + 1);
        }
        return destination;
    }

    public static void main (String [] args)
    {
        char [] chars = stringToChar ("this is a test", null, 0);

        for (char c: chars)
            System.out.println (c);
    }
}