import java.lang.reflect.Field;

public class test {
  public void method1() {
    System.out.println(getThisOrNull(new Object(){}));
  }

  public static void method2() {
    System.out.println(getThisOrNull(new Object(){}));
  }

  private static Object getThisOrNull(final Object o) {
    for (Field f: o.getClass().getDeclaredFields()) {
      if (f.getType().equals(test.class)) {
        try {
          return f.get(o);
        }
        catch (IllegalAccessException e) {
          // Omm nom nom...
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    test t = new test();
    System.out.println(t);
    t.method1();
    t.method2();
  }
}