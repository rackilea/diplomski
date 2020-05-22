import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class A {

    public static void main(String[] args) throws Exception {
        System.out.println("Before :: " + B.get());
        Field field = B.class.getDeclaredField("arr");
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        System.out.println("Peek   :: " + ((String[]) field.get(null))[0]);
        field.set(null, new String[] { "Good bye, World!" });
        System.out.println("After  :: " + B.get());
    }
}

class B {
    private static final String[] arr = new String[] { "Hello, World!" };

    public static String get() {
        return arr[0];
    }
}