import java.lang.reflect.Method;

public class Demo {

  public static void main(String[] args) throws Exception{
      Class[] parameterTypes = new Class[1];
      parameterTypes[0] = String.class;
      Method method1 = Demo.class.getMethod("method1", parameterTypes);

      Demo demo = new Demo();

      Object[] parameters = new Object[1];
      parameters[0] = "message";
      method1.invoke(demo , parameters);
  }

  public void method1(String message) {
      System.out.println(message);
  }

}