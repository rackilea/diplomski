import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class StaticTestWithCategoryCounter {

    public static final String ROOT_DIR_TO_SCAN = "bin";
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


    public static void computeCategoryCounters() throws Exception {
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

    public static List<String> listNameOfAvailableClasses(String rootDirectory, File directory, String packageName) throws ClassNotFoundException {
        List<String> classeNameList = new ArrayList<>();

        if (!directory.exists()) {
            return classeNameList;
        }

        File[] files = directory.listFiles();
        for (File file : files) {           

            if (file.isDirectory()) {
                if (file.getName().contains("."))
                    continue;

                classeNameList.addAll(listNameOfAvailableClasses(rootDirectory, file, packageName));
            } else if (file.getName().endsWith(".class")) {
                String qualifiedName = file.getPath().substring(rootDirectory.length() + 1);
                qualifiedName = qualifiedName.substring(0, qualifiedName.length() - 6).replaceAll(File.separator, ".");

                if (packageName ==null || qualifiedName.startsWith(packageName))
                    classeNameList.add(qualifiedName);
            }
        }

        return classeNameList;
    }

    public static List<Class<?>> loadAllAvailableClasses(String rootDirectory, String packageName) throws ClassNotFoundException {
        List<String> classeNameList = listNameOfAvailableClasses(rootDirectory, new File(rootDirectory), packageName);
        List<Class<?>> classes = new ArrayList<>();

        for (final String className: classeNameList) {
            classes.add(Class.forName(className));
        }

        return classes;
    }

    public static void main(String[] args) {
        try {           
            loadAllAvailableClasses(ROOT_DIR_TO_SCAN, MAIN_TEST_PACKAGES);
            computeCategoryCounters();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}