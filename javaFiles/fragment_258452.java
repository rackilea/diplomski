public class Digits
{

    public static void main(String[] args)
    {
        int[] b = { 1, 1, 1, 1, 2 };
        int c = Digits.numberCount(b, 5);
        System.out.println(c);
    }

    public static int numberCount(int[] numbers, int number)
    {
        int count = 0;
        for (int element : numbers)
        {
            if (number == element)
                count++;
        }
        return count;
    }
}