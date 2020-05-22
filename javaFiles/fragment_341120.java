import <package>.ValueSupplier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassFromAnotherPackage {

    @SuppressWarnings("unchecked")
    public void methodFromAnotherPackage()
            throws IllegalAccessException, InvocationTargetException, InstantiationException {

        final Constructor<?>[] constructors = ValueSupplier.Value.class.getDeclaredConstructors();

        if (constructors.length > 0) {
            final Constructor<ValueSupplier.Value> constructor = (Constructor<ValueSupplier.Value>) constructors[0]; // 1
            constructor.setAccessible(true); // 2
            final ValueSupplier.Value value = constructor.newInstance(1L, "str1", "str2"); // 3
        }

    }

}