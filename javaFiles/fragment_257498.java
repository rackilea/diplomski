public class Foo
{
  public static void main(String[] args)
  {
    String input = "2+2";
    String[] parts = input.split("\\+");
    int operand1 = Integer.parseInt(parts[0]);
    int operand2 = Integer.parseInt(parts[1]);
    int result = operand1 + operand2;
    System.out.println(input + "=" + result);
  }
}