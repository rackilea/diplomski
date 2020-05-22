@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@interface Printable { }

class Test {

  @Printable String A;
  @Printable String B;
  @Printable String C;

  public void printAll() {
    for (Field field : getClass().getDeclaredFields()) {
      if (field.isAnnotationPresent(Printable.class)) {
        try {
          System.out.println(field.get(this));
        } catch (Exception e) {
          throw new RuntimeException(e);
        }       
      }
    }
  }

}