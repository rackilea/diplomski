public class Overflow
{
    public static void main(String[] args)
    {
        long seconds = System.currentTimeMillis();
        long first = (seconds / (1000L * 60L * 60L * 24L)) / 365L;
        long i = 1000L * 60L * 60L * 24L * 365L;
        long first1;
        first1 = seconds / i;
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(first);
        System.out.println(first1);
        System.out.println(first1/first);
    }
}