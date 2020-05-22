import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class AbstractFactory {

    @SuppressWarnings("unchecked")
    public static <A> A createDefaultImplementation(Class<A> abstractClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(abstractClass);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (!Modifier.isAbstract(method.getModifiers())) {
                    return methodProxy.invokeSuper(proxy, args);
                } else {
                    Class type = method.getReturnType();
                    if (type.isPrimitive() && !void.class.equals(type)) {
                        return Array.get(Array.newInstance(type, 1), 0);
                    } else {
                        return null;
                    }
                }
            }
        });
        return (A) enhancer.create();
    }

    @SuppressWarnings("unchecked")
    public static <A> A createDefaultImplementation(String className) throws ClassNotFoundException{
        return (A) createDefaultImplementation(Class.forName(className));
    }
}