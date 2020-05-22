public class st {
  public static void main(String[] args) {
    String hello = "hello";
    String helloReference = hello; // making helloReference and hello refer to same object.
    helloReference += " world"; // perform +=
    System.out.format("`hello` = %s, `helloReference` = %s\n",
        hello, helloReference);
  }
}