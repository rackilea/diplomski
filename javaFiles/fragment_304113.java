import java.lang.reflect.*;

/**
 *
 * @author Administrator
 */
class SampleTwo {

    public static class A<T> {

        public T getT(T args) {
            return args;
        }
    }

    static class B extends A<String> {

        public String getT(String args) {
            return args;
        }
    }
}

public class BridgeTEst {

    public static void main(String[] args) {
        test(SampleTwo.B.class);
    }

    public static boolean test(Class c) {
        Method[] methods = c.getMethods();
        for (Method method : methods) {

            if (method.isSynthetic() || method.isBridge()) {
                System.out.println("Method Name = "+method.getName());
                System.out.println("Method isBridge = "+method.isBridge());
                System.out.println("Method isSynthetic = "+method.isSynthetic());
                return  true;
            }
        // More code.
        }
        return false;
    }
}