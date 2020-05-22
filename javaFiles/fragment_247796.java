public interface InterfaceForB {
  void b();
  void a();
}

public class A {
  public void a(){}
}

public class B extends A implements InterfaceForB{
  public void b(){}
}