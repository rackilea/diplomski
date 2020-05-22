import java.text.*;

public class Test
{
    public static void main(String[] args)
    {
        double value = 9.01236789E9;
        String text = String.format("%.0f", value);
        System.out.println(text); // 9012367890

        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(0);
        format.setGroupingUsed(false);
        System.out.println(format.format(value)); // 9012367890
    }
}