import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main
{
    public static void main(final String[] argv) 
        throws ClassNotFoundException, 
               NoSuchMethodException, 
               InstantiationException, 
               IllegalAccessException,
               IllegalArgumentException,
               InvocationTargetException 
    {
        final Class<?> clazz;
        final Method   method;
        final Object   instance;

        clazz = Class.forName(argv[0]);
        method = clazz.getMethod(argv[1] /*, types */);
        instance = clazz.newInstance();
        method.invoke(instance /*, arguments */);
    }
}