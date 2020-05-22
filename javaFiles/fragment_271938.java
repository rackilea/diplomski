public class Fibonacci
{
    public static void main(String[] args)
    {
        int[] fibMembers = buildFibArray(9);
        printFibArray(fibMembers);
    }

    private static void printFibArray(int[] fibMembers)
    {
        for (int i = 0; i < fibMembers.length; i++)
        {
            System.out.print(fibMembers.length-i);
            System.out.print(": ");
            System.out.print(fibMembers[i]);
            if (fibMembers[i] % 2 == 0)
            {
                System.out.print(" *");
            }
            System.out.println("");
        }
    }

    private static int[] buildFibArray(int maxIndex)
    {
        int[] fibMembers = new int[maxIndex];

        if (maxIndex > 0)
        {
            fibMembers[0] = 1;
            if (maxIndex > 1)
            {
                fibMembers[1] = 1;

                for (int i = 2; i < fibMembers.length; i++)
                {
                    fibMembers[i] = fibMembers[i-2] + fibMembers[i-1];
                }
            }
        }
        return fibMembers;
    }
}