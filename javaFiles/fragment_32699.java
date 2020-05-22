import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex
{
    public static void main(String[] args) throws Exception
    {
        final String methodName = "getFooValue";
        Object foo = new FooImpl();
        Class<?> c = foo.getClass();
        Method m = c.getDeclaredMethod(methodName, null);
        System.out.println(m.invoke(foo));
    }
}

interface Foo
{
    public int getFooValue();
}

class FooImpl implements Foo
{
    @Override public int getFooValue() { return 49; }
}