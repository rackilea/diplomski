public class MyReflection {

public static void main(String[] args) throws ClassNotFoundException,
        InstantiationException, IllegalAccessException,
        NoSuchMethodException, SecurityException, IllegalArgumentException,
        InvocationTargetException {
    Class outer = Class.forName("reflaction.MyReflection");
    Object outerInstance = outer.newInstance();

    Class<?> inner = Class
            .forName("reflaction.MyReflection$TestReflection");
    Constructor<?> constructor = inner.getDeclaredConstructor(outer);

    TestReflection innerInstance = (TestReflection) constructor
            .newInstance(outerInstance);

    innerInstance.demo();
}

class TestReflection {

    public void demo() {
        System.out.println("reflection occurs");
    }
}