public class Parent {
  private String output;

  public Parent(String output) {
    this.output = output;
  }

  public Parent() {
    this("hallo");
  }

  public void print() {
    System.out.println(output );
  }
}

public class Child extends Parent {
  public Child() {
    super("child");
  }
}