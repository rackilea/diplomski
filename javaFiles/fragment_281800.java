public class Test
{
    public static void main(String[] a)
    {
        printNumber(0);
    }
public static void printNumber(int i)
{
    if (i < 100)
    {
        System.out.println(i);
        i = i + 1;
        printNumber(i);
    }return;
}
}