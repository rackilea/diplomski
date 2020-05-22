public class ArrayIterator
{
    public static void main(String[] argv)
    {
        String[] strs = new String[] { "1", "2", "3", "4", "5" };
        enhancedPrint(strs);
        normalPrint(strs);
    }

    public static void enhancedPrint( String[] strs )
    {
        for (String s : strs)
        {
            System.out.println(s);
        }
    }

    public static void normalPrint( String[] strs )
    {
        String[] localArray = strs;
        int len = localArray.length;
        for (int i = 0; i < len; i++)
        {
            String s = localArray[i];
            System.out.println(s);
        }
    }
}