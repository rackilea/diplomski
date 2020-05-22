public class Example {
  public static class Foo {
    public void printSomething() {
      System.out.println("Foo");
    }
  }

  public static class Bar extends Foo {
    @Override
    public void printSomething() {
      System.out.println("Bar");
    }
  }

  public static void main(String[] args) {
    Bar bar = new Bar();
    bar.printSomething();
  }
}