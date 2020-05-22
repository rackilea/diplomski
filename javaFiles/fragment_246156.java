public class AnnotationTest {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Annotation.class;
    Method method = clazz.getDeclaredMethod("value");
    String value = (String) method.getDefaultValue();
    System.out.println(value);
  }

  public @interface Annotation {
    String value() default "default value";
  }
}