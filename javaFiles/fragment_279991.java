public class LooseCouplingTest {
    public static void main(String... args) throws Exception {
        String className = args[0];
        Class<?> clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        java.lang.reflect.Method connect = clazz.getMethod("connect");
        connect.invoke(obj);
    }
}