public class Test
{
    public static void main(String[] args)
    {
        int intProduct = 24 * 60 * 60 * 1000 * 1000;
        long longProduct = 24L * 60 * 60 * 1000 * 1000;
        System.out.println(intProduct); // Prints 500654080
        System.out.println(longProduct); // Prints 86400000000
   }
}