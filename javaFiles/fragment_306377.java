public class ReflectionDemo {

  public void print(String str, int value) {
    System.out.println(str);
    System.out.println(value);
  }

  public static int getNumber() { return 42; }

  public static void main(String[] args) throws Exception {
    Class<?> clazz = ReflectionDemo.class;
    // static call
    Method getNumber = clazz.getMethod("getNumber");
    int i = (Integer) getNumber.invoke(null /* static */);
    // instance call
    Constructor<?> ctor = clazz.getConstructor();
    Object instance = ctor.newInstance();
    Method print = clazz.getMethod("print", String.class, Integer.TYPE);
    print.invoke(instance, "Hello, World!", i);
  }
}