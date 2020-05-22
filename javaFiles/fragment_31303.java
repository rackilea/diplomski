/* Main.java */

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        doOriginalImplementation();     // Prints "hello"
        doReflectionImplementation();   // Prints "hello"
    }

    public static void doOriginalImplementation() {
        Foo foo = new Foo();
        ExtendedCommandAnnotation e = foo.getClass().getAnnotation(ExtendedCommandAnnotation.class);
        String startTag = e.annoPropStartTag();
        System.out.println(startTag);
    }

    public static void doReflectionImplementation() {
        Foo foo = new Foo();

        Annotation[] annotations = foo.getClass().getAnnotations();
        // or the statement below, depends on what you intent to do:
        // Annotation[] annotations = foo.getClass().getDeclaredAnnotations();

        Class classOfExtendedCommandAnnotation = null;
        Annotation annotationOnClassFoo = null;
        for (Annotation a : annotations) {
            Class classA = a.annotationType();
            if ("ExtendedCommandAnnotation".equals(classA.getName())) {
                classOfExtendedCommandAnnotation = classA;
                annotationOnClassFoo = a;
                break;
            }
        }

        Method methodAnnoPropStartTag = null;
        if (classOfExtendedCommandAnnotation != null) {
            try {
                methodAnnoPropStartTag = classOfExtendedCommandAnnotation.getMethod("annoPropStartTag");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        if (methodAnnoPropStartTag != null) {
            try {
                String startTag = (String) methodAnnoPropStartTag.invoke(annotationOnClassFoo);
                System.out.println(startTag);
            } catch (ClassCastException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}