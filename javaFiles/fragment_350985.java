public class Parent {

  private String output = "hallo";

  protected void setOutput(String output) {
    this.output = output;
  }

  public void print() {
    System.out.println(output );
  }
}

public class Child extends Parent {
  public Child() {
    setOutput("child");
  }
}