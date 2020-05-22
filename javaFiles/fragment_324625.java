public class ArrOfMixedArr
{
    public static void main (String args[])
    {
        Object[] arr = {
            new Integer [] {1, 2, 3}, 
            new String [] {"you", "and", "me"}, 
            new Character [] {'a', 'b', 'c'}};
        show (arr);

        byte b = 7;
        short s = 9;
        String o [][] = new String[200][1000];
        o[b][s] = "foobar";
        String foo = o[b][s];

        Object[][] ar2 = {
            new Integer [] {4, 5, 6}, 
            new String [] {"me", "and", "you"}, 
            new Character [] {'x', 'y', 'z'}};
        show (ar2);

        // exeptions:
        ar2[1][1] = 17; // expected: String
        ar2[2][0] = "double you"; // expected: Char
    }

    public static void show (Object[] arr)
    {
        for (Object o : arr) 
        {
            if (o instanceof Object[])
                show ((Object[]) o);
            else 
                System.out.print (o.toString () + "\t");
        }
        System.out.println ();
    }
}