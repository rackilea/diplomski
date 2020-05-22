import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DecimalFormatExample
{
  public static void main(String args[])
  {
  double amount = 2192.015;
  NumberFormat formatter = new DecimalFormat("#0.00");
  System.out.println("The Decimal Value is:"+formatter.format(amount));
  }
}