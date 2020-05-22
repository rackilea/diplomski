package misc.category;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UnitTestWithCategory.class })
public class TestSuiteCountComputer {

    public static final String MAIN_TEST_PACKAGES = "misc.category";

    private static final Class<?>[] getClasses(final ClassLoader classLoader)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Class<?> CL_class = classLoader.getClass();
        while (CL_class != java.lang.ClassLoader.class) {
            CL_class = CL_class.getSuperclass();
        }
        java.lang.reflect.Field ClassLoader_classes_field = CL_class.getDeclaredField("classes");
        ClassLoader_classes_field.setAccessible(true);
        Vector<?> classVector = (Vector<?>) ClassLoader_classes_field.get(classLoader);

        Class<?>[] classes = new Class[classVector.size()]; // Creates an array to avoid concurrent modification
                                                            // exception.
        return classVector.toArray(classes);
    }

    // Registers the information.
    private static final void registerTest(Map<String, AtomicInteger> testByCategoryMap, String category) {
        AtomicInteger count;
        if (testByCategoryMap.containsKey(category)) {
            count = testByCategoryMap.get(category);
        } else {
            count = new AtomicInteger(0);
            testByCategoryMap.put(category, count);
        }

        count.incrementAndGet();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        Map<String, AtomicInteger> testByCategoryMap = new HashMap<>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        while (classLoader != null) {
            for (Class<?> classToCheck : getClasses(classLoader)) {
                String packageName = classToCheck.getPackage() != null ? classToCheck.getPackage().getName() : "";
                if (!packageName.startsWith(MAIN_TEST_PACKAGES))
                    continue;

                // For each methods of the class.
                for (Method method : classToCheck.getDeclaredMethods()) {
                    Class<?>[] categoryClassToRegister = null;
                    boolean ignored = false;
                    for (Annotation annotation : method.getAnnotations()) {
                        if (annotation instanceof org.junit.experimental.categories.Category) {
                            categoryClassToRegister = ((org.junit.experimental.categories.Category) annotation).value();
                        } else if (annotation instanceof org.junit.Ignore) {
                            ignored = true;

                        } else {
                            // Ignore this annotation.
                            continue;
                        }
                    }

                    if (ignored) {
                        // If you want to compute count of ignored test.
                        registerTest(testByCategoryMap, "(Ignored Tests)");
                    } else if (categoryClassToRegister != null) {
                        for (Class<?> categoryClass : categoryClassToRegister) {
                            registerTest(testByCategoryMap, categoryClass.getCanonicalName());
                        }
                    }

                }

            }
            classLoader = classLoader.getParent();
        }

        System.out.println("\nFinal Statistics:");
        System.out.println("Count of Tests\t\tCategory");
        for (Entry<String, AtomicInteger> info : testByCategoryMap.entrySet()) {
            System.out.println("\t" + info.getValue() + "\t\t" + info.getKey());
        }

    }

}