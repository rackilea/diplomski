import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public Test(String arg) {
        System.err.println("I'm in consturctor with one String arg: " + arg);
    }

    public static <T extends Test> T createInstance(Class<T> clazz) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<T>[] constructors = (Constructor<T>[]) clazz.getDeclaredConstructors();
        Constructor<T> constructor = constructors[0];
        return constructor.newInstance("ARG");
    }

    public static void main(String[] args) throws Exception {
        createInstance(Test.class);
    }
}