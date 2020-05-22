public abstract class SuperClass {
  private String value;

  public SuperClass(String value) {
    this.value = value;
  }
}


public class SubClass extends SuperClass {
  private static final String CONSTANT = "";

  public SubClass() {
    super(CONSTANT);
  }
}