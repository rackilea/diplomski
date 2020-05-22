import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        A a = new C();
        a.doAllStuff();
    }
}

class A
{
    protected List<String> list = new ArrayList<String>();

    @SuppressWarnings("unused")
    private static void doStuff(A a)
    {
        a.list.add("I am A");
    }

    final public void doAllStuff()
    {
        List<Class<?>> list = new ArrayList<Class<?>>();
        Class<?> clazz = this.getClass();
        while (A.class.getSuperclass() != clazz)
        {
            list.add(clazz);
            clazz = clazz.getSuperclass();
        }
        System.out.println(list);
        for (Class<?> myClass : list)
        {
            try
            {
                Method method = myClass.getDeclaredMethod("doStuff"
                                                          , myClass);
                // Method is private? Make it accessible anyway.
                method.setAccessible(true);
                method.invoke(this, this);
            }
            catch (NoSuchMethodException e)
            {
                // Method not found, continue with next class.
                continue;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(this.list);
    }
}

class B extends A
{
    @SuppressWarnings("unused")
    private static void doStuff(B b)
    {
        b.list.add("I am B");
    }
}

class C extends B {}