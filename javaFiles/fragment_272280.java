public class Test {
    private String hello;

    public void setHello(String hello) {
        this.hello = hello; 
    }

    public String getHello() {
        return hello;
    }
}
public class StackOverflow {
  public static void main(String[] args) {
    Test test = new Test();
    test.setHello("Hello world");
    System.out.println(test.getHello());
  }
}