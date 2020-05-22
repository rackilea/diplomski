public class Testing{
  private int Sample(int c)
  {
    int a = 1;
    int b = 2;
    c = a + b;
    return c;
 }
  public static void main(String []args)
 {
    Testing t = new Testing(); // instantiate a Testing class object
    int result = t.Sample(1); // use the instance t to invoke a method on it
    System.out.println(result);
 }
}