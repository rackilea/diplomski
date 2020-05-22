import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.example.something.A;

public class Initilizer {

    public static void initialize(Object object, Set<String> packages)
            throws IllegalArgumentException,
            IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            Class<?> fieldClass = field.getType();

            // skip primitives
            if (fieldClass.isPrimitive()) {
                System.out.println("Skipping primitive: " + fieldName);
                continue;
            }

            // skip if not in packages
            boolean inPackage = false;
            for (String pack : packages) {
                if (fieldClass.getPackage().getName().startsWith(pack)) {
                    inPackage = true;
                }
            }
            if (!inPackage) {
                System.out.println("Skipping package: "
                        + fieldClass.getPackage().getName());
                continue;
            }

            // allow access to private fields
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);

            Object fieldValue = field.get(object);
            if (fieldValue == null) {
                System.out.println("Initializing: " + fieldName);
                try {
                    field.set(object, fieldClass.newInstance());
                } catch (IllegalArgumentException | IllegalAccessException
                        | InstantiationException e) {
                    System.err.println("Could not initialize "
                            + fieldClass.getSimpleName());
                }
            } else {
                System.out
                        .println("Field is already initialized: " + fieldName);
            }

            fieldValue = field.get(object);

            // reset accessible
            field.setAccessible(isAccessible);

            // recursive call for sub-objects
            initialize(fieldValue, packages);
        }

    }

    public static void main(String[] args) throws Exception {

        A a = new A();

        // Packages to initialize
        Set<String> packages = new HashSet<>();
        packages.add("com.example");
        packages.add("org.example");

        initialize(a, packages);
    }
}