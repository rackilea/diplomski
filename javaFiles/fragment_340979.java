public class EmumReflect {

    public static void main(String[] args) throws Exception {
        f1();
        f2();
    }

    public static void f1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException,
            InvocationTargetException {
        Class<?> forName = Class.forName("snippet.EnumTest");
        Object fOne = forName.getField("ONE").get(null);
        Object fTwo = forName.getField("TWO").get(null);
        Method method = forName.getMethod("hello");
        System.out.println(method.invoke(fOne));
        System.out.println(method.invoke(fTwo));
    }

    public static void f2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException,
            InvocationTargetException {
        Class<?> forNamex = Class.forName("snippet.EnumTest");
        Object fTwo = forNamex.getField("TWO").get(null);
        Class<?> forName = fTwo.getClass();
        Method method = forName.getMethod("hello");
        System.out.println(method.invoke(fTwo));
    }
}