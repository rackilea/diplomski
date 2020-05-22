public abstract class SuperClass {
  public abstract String getSomeValue();

  public void method() {
     String s = getSomeValue();
  }
}


public class SubClass extends SuperClass {
  private static final String CONSTANT = "";

  public String getSomeValue() {
    return CONSTANT;
  }
}