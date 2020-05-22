package CallBefore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExampleProxy implements InvocationHandler {

    private ExampleInterface obj;

    public static ExampleInterface newInstance(ExampleInterface obj) {
    return (ExampleInterface) java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
        obj.getClass().getInterfaces(), new ExampleProxy(obj));
    }

    private ExampleProxy(ExampleInterface obj) {
    this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    Object result;
    try {
        if (m.getName().startsWith("function")) {
        obj.refresh();
        }
        result = m.invoke(obj, args);
    } catch (InvocationTargetException e) {
        throw e.getTargetException();
    } catch (Exception e) {
        throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
    }
    return result;
    }
}