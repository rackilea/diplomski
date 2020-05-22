import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Child.class;
            Object child = clazz.newInstance();
            Field f1 = child.getClass().getDeclaredField("age");

            // Because 'age' field is private
            // we make it accesible
            f1.setAccessible(true);

            // Set the desired value
            f1.set(child, 10);
            System.out.println("Child: " + child);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Child {
    private int age;

    @Override
    public String toString() {
        return "Child [age=" + age + "]";
    }

}