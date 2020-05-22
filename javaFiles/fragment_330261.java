import java.lang.reflect.*;
import java.util.*;

public class Demo
{
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("onStart", "abc");
        map.put("onEnd", "def");
        Library library = new LibraryProxy(map, new LibraryImpl()).proxy();
        library.onStart();
        library.onEnd();
        library.onRun();
    }
}

interface Library
{
    void onStart();
    void onEnd();
    void onRun();
}

class LibraryImpl
{
    public void abc() { System.out.println("Start"); }
    public void def() { System.out.println("End"); }
}

class LibraryProxy implements InvocationHandler
{
    Map<String, String> map;
    Object impl;

    public LibraryProxy(Map<String, String> map, Object impl)
    {
        this.map = map;
        this.impl = impl;
    }

    public Library proxy()
    {
        return (Library) Proxy.newProxyInstance(Library.class.getClassLoader(),
            new Class[] { Library.class }, this);
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
        Object res = null;
        String name = map.get(m.getName());
        if (name == null) {
            System.out.println("[" + m.getName() + " is not defined]");
        } else {
            m = impl.getClass().getMethod(name, m.getParameterTypes());
            res = m.invoke(impl, args);
        }
        System.out.println("super duper");
        return res;
    }
}