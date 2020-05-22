public class Test
{

    public static void main(String[] args)
    {
        System.out.println(concatenateHorizontally("AAA\nBBB\nCCC", "111\n222\n333", "\n", " "));
        System.out.println(concatenateHorizontally("AAA\nBBB", "111\n222\n333", "\n", " "));
        System.out.println(concatenateHorizontally("AAA\nBBB\nCCC", "111\n222", "\n", " "));
    }

    private static String concatenateHorizontally(final String left, final String right, String br, String concat)
    {
        {

            String[] lefts = left.split(br);
            String[] rights = right.split(br);
            int max = Math.max(lefts.length, rights.length);

            StringBuilder sB = new StringBuilder();

            for (int i = 0; i < max; i++)
            {

                if (i < lefts.length)
                    sB.append(lefts[i]).append(concat);

                if (i < rights.length)
                    sB.append(rights[i]);

                sB.append(br);
            }

            return sB.toString();
        }
    }
}