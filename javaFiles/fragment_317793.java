import java.util.Scanner;
public class Main
{
  public static void main (String[]args)
  {
    String str1, str2;
      System.out.println ("1 Input");
      str1 = input ();
      System.out.println ("2 Input");
      str1 = input ();
  }
  public static String input ()
  {
    Scanner sc = new Scanner (System.in);
    return sc.next ();
  }
}