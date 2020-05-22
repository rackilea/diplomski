import java.lang.reflect.*;

public class ImplementInterfaceWithReflection {
    public static void main(String[] args) throws Exception {
        String interfaceName = Foo.class.getName();
        Object proxyInstance = implementInterface(interfaceName);
        Foo foo = (Foo) proxyInstance;
        System.out.println(foo.getAnInt());
        System.out.println(foo.getAString());
    }

    static Object implementInterface(String interfaceName)
            throws ClassNotFoundException {
        // Note that here we know nothing about the interface except its name
        Class clazz = Class.forName(interfaceName);
        return Proxy.newProxyInstance(
            clazz.getClassLoader(),
            new Class[]{clazz},
            new TrivialInvocationHandler());
    }

    static class TrivialInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            System.out.println("Method called: " + method);
            if (method.getReturnType() == Integer.TYPE) {
                return 42;
            } else {
                return "I'm a string";
            }
        }
    }

    interface Foo {
        int getAnInt();
        String getAString();
    }
}