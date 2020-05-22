import java.lang.reflect.Field;
public class ToStringMaker {
  public ToStringMaker( Object o) {

  Class<? extends Object> c = o.getClass();
  Field[] fields = c.getDeclaredFields();
  for (Field field : fields) {
      String name = field.getName();  
    field.setAccessible(true);          
      try {
        System.out.format("%n%s: %s", name, field.get(o));
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
  }
 }}