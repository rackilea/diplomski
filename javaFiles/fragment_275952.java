import java.lang.reflect.Field;


public class Test 
{
    public static void main(final String[] argv) 
        throws NoSuchFieldException, 
               IllegalArgumentException,
               IllegalAccessException
    {
        final X x;

        x = new X();
        System.out.println(x);
        changeValue(x);
        System.out.println(x);
    }

    private static void changeValue(final X x) 
        throws NoSuchFieldException, 
               IllegalArgumentException,
               IllegalAccessException
    {
        final Class<X> clazz;
        final Field    field;

        clazz = X.class;
        field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        field.set(x, Integer.MAX_VALUE);
    }
}