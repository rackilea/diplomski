import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

public class Utils {

 public static <C> C createInmutableBean(Class<C> clazz, final C instance)
        throws InstantiationException, IllegalAccessException {
    if (!clazz.isAssignableFrom(instance.getClass())) {
        throw new IllegalArgumentException("given instance of class "
                + instance.getClass() + " is not a subclass of " + clazz);
    }
    ProxyFactory f = new ProxyFactory();
    f.setSuperclass(clazz);
    f.setFilter(new MethodFilter() {
        public boolean isHandled(Method m) {
            // ignore finalize()
            return !m.getName().equals("finalize");
        }
    });
    Class c = f.createClass();
    MethodHandler mi = new MethodHandler() {
        public Object invoke(Object self, Method m, Method proceed,
                Object[] args) throws Throwable {
            if (m.getName().startsWith("set")) {
                throw new RuntimeException("this bean is inmutable!");
            }

            return m.invoke(instance, args); // execute the original method
                                                // over the instance
        }
    };
    C proxy = (C) c.newInstance();

    ((Proxy) proxy).setHandler(mi);
    return (C) proxy;
 }
}