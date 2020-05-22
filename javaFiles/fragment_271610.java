import java.lang.reflect.*;

public class Main  {

    public static void invokeMethod(String className)  {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod("method");
            method.invoke(null);   // null is used for static methods. For instance methods, pass the instance.
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        invokeMethod("Interface");
    }
}