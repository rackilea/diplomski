import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DoItYourAop {

  public static void main(String[] args) {
    SaysHello saysHello = new SaysHelloImpl();
    InvocationHandler logger = new LoggingProxy(saysHello);
    SaysHello proxy = (SaysHello) Proxy.newProxyInstance(SaysHello.class.getClassLoader(),
        new Class[]{SaysHello.class}, logger);
    proxy.sayHello();
  }

  public interface SaysHello {

    void sayHello();

    void sayGoodbye();
  }

  public static class SaysHelloImpl implements SaysHello {
    @Log
    @Override
    public void sayHello() {
      System.out.println("Says Hello");
    }

    @Override
    public void sayGoodbye() {
      System.out.println("Says Goodbye");
    }
  }

  @Retention(RUNTIME)
  @interface Log {
  }

  public static class LoggingProxy implements InvocationHandler {

    private final Object proxied;

    public LoggingProxy(Object proxied) {
      this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Method proxiedMethod = proxied.getClass().getMethod(method.getName(), method.getParameterTypes());
      boolean log = proxiedMethod.isAnnotationPresent(Log.class);
      if (log) {
        System.out.println("Before");
      }

      Object result = method.invoke(proxied, args);

      if (log) {
        System.out.println("After");
      }

      return result;
    }
  }
}