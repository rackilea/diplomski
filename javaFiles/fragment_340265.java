public interface MyCopy {
  Object copy();
}

public class MyClass implements MyCopy {
  private int myVar;
  public MyClass() { this.myVar = 0; }
  public MyClass(int myVar) { this.myVar = myVar; }
  public Object copy() { return new MyClass(myVar); }
}