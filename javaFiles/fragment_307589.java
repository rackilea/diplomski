import java.math.BigInteger;
import java.text.NumberFormat;

public class MyClass 
{
  public static void main(String[] args)
  {
    BigInteger x = BigInteger.ONE;
    BigInteger two = BigInteger.valueOf(2L);
    NumberFormat nf = NumberFormat.getInstance();

    for(int p = 1; p <= 100; p++)
    {
      String o = nf.format(x);
      System.out.println("Day " + p + " gets " + o);
      x = x.multiply(two);
    }

  }
}