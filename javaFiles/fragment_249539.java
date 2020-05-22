public class Test {
  public static void main(String[] args) {
    String op = "\u221A";
    char operator1 = op.charAt(0);
    char operator2 = '\u221a';
    char operator3 = 0x221a;
    System.out.println(operator1 == operator2);
    System.out.println(operator2 == operator3);
  }
}