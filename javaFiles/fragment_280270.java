import java.lang.reflect.InvocationTargetException;

public class Factory {

    <P, T extends Foo<P>> T build(Class<T> clazz, P param)
            throws IllegalArgumentException, SecurityException,
               InstantiationException, IllegalAccessException,
               InvocationTargetException, NoSuchMethodException {
        return clazz.getConstructor(param.getClass()).newInstance(param);
    }

    public static void main(String[] args)
            throws IllegalArgumentException, SecurityException,
                InstantiationException, IllegalAccessException,
                InvocationTargetException, NoSuchMethodException {

        Factory f = new Factory();

        System.out.println(f.build(FooInt.class, Integer.valueOf(1)));
        System.out.println(f.build(FooDouble.class, Double.valueOf(1.1)));
    }
}