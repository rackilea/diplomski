package example.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

public class SetProxyFactory {

    public static Set<?> getSetProxy(final Set<?> s) {
        final ClassLoader classLoader = s.getClass().getClassLoader();
        final Class<?>[] interfaces = new Class[] {Set.class};
        final InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {

                if (method.getName().equals("add")) {
                    System.out.println("add() intercepted");
                    // do/return whatever you want
                }

                // or invoke the real method
                return method.invoke(s, args);
            }
        };

        final Object proxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return (Set<?>) proxy;
    }
}