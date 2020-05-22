import java.math.*;

public class Test
{
    public static void main(String[] args)
    {
        showRounded(new BigDecimal("0.4"));
        showRounded(new BigDecimal("0.5"));
    }

    static void showRounded(BigDecimal input)
    {
        BigDecimal output = input.setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(input + " => " + output);
    }
}