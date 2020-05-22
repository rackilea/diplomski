import java.util.*;
import java.lang.reflect.*;

public class GenericReflection {
  public static void main(String[] args) throws Exception {
    Method m = GenericReflection.class.getDeclaredMethod("foo");
    System.out.println(m.getGenericReturnType());
  }

  public static List<String> foo() {
    return null;
  }
}