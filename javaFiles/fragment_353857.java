import java.lang.reflect.Method;

public class Example {
    private void one() {
    }

    private void two() {
    }

    private void three() {
    }

    public static void main(String[] args) {
        Example program = new Example();
        Class progClass = program.getClass();

        // Get all the methods associated with this class.
        Method[] methods = progClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Method " + (i + 1) + " :"
                    + methods[i].toString());
        }
    }
}