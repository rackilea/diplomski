import java.text.*;

public class Test
{
    public static void main(String[] args)
    {
        float y = 12.34567f;
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println(formatter.format(y));
    }
}