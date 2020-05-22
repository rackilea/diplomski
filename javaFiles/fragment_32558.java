import java.math.BigDecimal;

public class BigDecimalToPlainStringPerformance
{
    public static void main(String[] args)
    {
        for (int n = 10000; n <= 50000; n += 5000)
        {
            BigDecimal number = factorial(n);
            long before = System.nanoTime();
            String result = number.toPlainString();
            long after = System.nanoTime();

            double ms = (after - before) / 1e6;
            System.out.println(n + "! took " + ms +
                " ms, length " + result.length());
        }
    }

    private static BigDecimal factorial(int n)
    {
        BigDecimal number = new BigDecimal(1);
        for (int i = 1; i < n; i++)
        {
            number = number.multiply(new BigDecimal(i));
        }
        return number;
    }

}