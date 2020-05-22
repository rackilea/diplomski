package stackoverflow;

import java.lang.reflect.Method;

public class MethodEquals
{
    public static void main(String[] args) throws Exception
    {
        checkMethods();
        checkClasses();
    }

    static void checkMethods() throws Exception
    {
        Method m0 = MethodEquals.class.getMethod("exampleMethod", int.class);
        Method m1 = MethodEquals.class.getMethod("exampleMethod", int.class);

        boolean identical = (m0 == m1);
        boolean equal = m0.equals(m1);

        System.out.println("Methods: "+(identical == equal)); // prints "false"
    }

    static void checkClasses() throws Exception
    {
        Class<?> c0 = Class.forName("stackoverflow.MethodEquals");
        Class<?> c1 = Class.forName("stackoverflow.MethodEquals");

        boolean identical = (c0 == c1);
        boolean equal = c0.equals(c1);

        System.out.println("Classes: "+(identical == equal)); // prints "true"
    }

    public float exampleMethod(int i)
    {
        return 42.0f;
    }
}