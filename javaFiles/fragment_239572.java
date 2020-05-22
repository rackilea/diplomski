public class HelloWorld
{
  public static void main(String[] args)
  {
    char[][] x = new char[7][7];
    char[] h = "Helpers".toCharArray();
    x[0] = h;
    for (char c : x[0]) System.out.println(c);
   }
}