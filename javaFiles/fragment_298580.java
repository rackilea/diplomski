import java.lang.reflect.Field;

public class NonInstantiableClass {
    private static Integer a1 = 1;
    private static String a2 = "a";

    private NonInstantiableClass () {
         throw new AssertionError();
    }

    public static void printVariables () throws IllegalAccessException {

        for (Field field : NonInstantiableClass.class.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName()
                    + " - " + field.getType()
                    + " - " + field.get(NonInstantiableClass.class));
        }
    }

    public static void main(String args[]) throws IllegalAccessException {
        NonInstantiableClass.printVariables();
    }
}