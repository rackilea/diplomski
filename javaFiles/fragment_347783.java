import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

public class DelegatingProxyExample {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();

        CommonInterface commonA = wrap(a);
        CommonInterface commonB = wrap(b);
        CommonInterface commonC = wrap(c);

        use(commonA);
        use(commonB);
        use(commonC);
    }

    private static void use(CommonInterface commonInterface) {
        System.out.println(commonInterface.id());
        System.out.println(commonInterface.version());
        System.out.println(commonInterface.foo());
        System.out.println(commonInterface.bar());
    }

    private static CommonInterface wrap(Object object) {
        CommonInterface commonInterface = (CommonInterface) Proxy.newProxyInstance(
            CommonInterface.class.getClassLoader(), 
            new Class[] { CommonInterface.class }, new Delegator(object));
        return commonInterface;
    }

}

// Partially based on the example from
// https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html
class Delegator implements InvocationHandler {

    private static Method hashCodeMethod;
    private static Method equalsMethod;
    private static Method toStringMethod;
    static {
        try {
            hashCodeMethod = Object.class.getMethod("hashCode", (Class<?>[]) null);
            equalsMethod = Object.class.getMethod("equals", new Class[] { Object.class });
            toStringMethod = Object.class.getMethod("toString", (Class<?>[]) null);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    private Object delegate;

    public Delegator(Object delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Class<?> declaringClass = m.getDeclaringClass();

        if (declaringClass == Object.class) {
            if (m.equals(hashCodeMethod)) {
                return proxyHashCode(proxy);
            } else if (m.equals(equalsMethod)) {
                return proxyEquals(proxy, args[0]);
            } else if (m.equals(toStringMethod)) {
                return proxyToString(proxy);
            } else {
                throw new InternalError("unexpected Object method dispatched: " + m);
            }
        } else {

            // TODO Here, the magic happens. Add some sensible error checks here!
            Method delegateMethod = delegate.getClass().getDeclaredMethod(
                m.getName(), m.getParameterTypes());
            return delegateMethod.invoke(delegate, args);
        }
    }

    protected Integer proxyHashCode(Object proxy) {
        return new Integer(System.identityHashCode(proxy));
    }

    protected Boolean proxyEquals(Object proxy, Object other) {
        return (proxy == other ? Boolean.TRUE : Boolean.FALSE);
    }

    protected String proxyToString(Object proxy) {
        return proxy.getClass().getName() + '@' + Integer.toHexString(proxy.hashCode());
    }
}

interface CommonInterface {
    UUID id();

    Long version();

    String foo();

    String bar();
}

class A {
    public UUID id() {
        return UUID.randomUUID();
    }

    public Long version() {
        return 1L;
    }

    public String foo() {
        return "fooA";
    }

    public String bar() {
        return "barA";
    }
}

class B {
    public UUID id() {
        return UUID.randomUUID();
    }

    public Long version() {
        return 2L;
    }

    public String foo() {
        return "fooB";
    }

    public String bar() {
        return "barB";
    }
}

class C {
    public UUID id() {
        return UUID.randomUUID();
    }

    public Long version() {
        return 3L;
    }

    public String foo() {
        return "fooC";
    }

    public String bar() {
        return "barC";
    }
}