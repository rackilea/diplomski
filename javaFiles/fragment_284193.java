public abstract class TopClass {
  public abstract void methodA();
  public abstract void methodB();
}

public abstract class ClassA extends TopClass {
  @Override
  public void methodA() {
    // Implementation
  }
}

public class ClassB extends ClassA {
  @Override
  public void methodB() {
    // Implementation
  }
}