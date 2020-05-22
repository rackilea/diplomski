import java.lang.reflect.Modifier;

public class Sandbox {
  public enum E {
    VALUE {};
  }

  public enum E2 {
    VALUE;
  }

  public static void main(String[] args) {
    System.out.println(E.class);
    System.out.println(E.VALUE.getClass());
    System.out.println("E.VALUE is subclass of E = " + E.VALUE.getClass().getSuperclass().equals(E.class));
    System.out.println("E modifiers: " + Modifier.toString(E.class.getModifiers()));
    System.out.println("E2 modifiers: " + Modifier.toString(E2.class.getModifiers()));
  }
}