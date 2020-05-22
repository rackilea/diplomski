import java.lang.reflect.Field;

public class Test {
   public static void main(String[] args) {
      new Test().run();
}

private void run() {
   Class<?> c = Foo.class;
   System.out.println("The following fields extend Component: ");
   for (Field f : c.getDeclaredFields()) {
      Class<?> fieldClass = f.getType();
      Class<java.awt.Component> compClass = java.awt.Component.class;      
      if (compClass.isAssignableFrom(fieldClass)) {
         System.out.println(f.getName());
      }
   }
 }
}