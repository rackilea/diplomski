import java.lang.reflect.*;

public class Duck {

  // The interface we use to access the duck typed object.
  public interface TheInterfaceIWant {
    int length();
    void quack();
  }

  // The underlying instance that does not implement TheInterfaceIWant!
  static final class Foo {
    public int length() { return 4; }
    public void quack() { System.out.println("Quack"); }
  }

  public static void main(String[] args) throws Exception {
    // Create an instance but cast away all useful type info.
    final Object aDuck = new Foo();

    TheInterfaceIWant aDuckWrapper = (TheInterfaceIWant) Proxy.newProxyInstance(
        TheInterfaceIWant.class.getClassLoader(),
        new Class[] { TheInterfaceIWant.class },
        new InvocationHandler() {
          public Object invoke(
              Object proxy, Method method, Object[] args)
              throws Throwable {
            return aDuck.getClass().getMethod(
                method.getName(), method.getParameterTypes()).invoke(aDuck, args);
          }
        });

    for (int n = aDuckWrapper.length(); --n >= 0;) {
      // Calling aDuck.quack() here would be invalid since its an Object.
      aDuckWrapper.quack();
    }
  }
}