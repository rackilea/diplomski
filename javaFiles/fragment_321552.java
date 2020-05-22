...
public class ClassB extends ClassA {
  ......
  @Override
  @PrePersist
  public void myCallback() {
        super.myCallback();
  }
  ......
}