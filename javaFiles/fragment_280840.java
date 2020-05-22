import java.io.PrintStream;

class Test
{
  public static void main(String[] paramArrayOfString)
    throws NumberFormatException
  {
    String str = "42";
    int i = Integer.parseInt(str);
    double d = i * 42.0D;
    System.out.println(d);
  }
}