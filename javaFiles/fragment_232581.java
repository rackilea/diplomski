import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

...

public static Runnable toRunnable(Method method, Object instance) throws ReflectiveOperationException {
    Lookup lookup = lookup();

    MethodHandle test = lookup.unreflect(method);       
    try {
        return (Runnable) LambdaMetafactory.metafactory(
            lookup,
            "run",
            methodType(Runnable.class, instance.getClass()),
            methodType(void.class),
            test,
            methodType(void.class)
        ).getTarget().invoke(instance);
    } catch (Throwable e) {
        throw new RuntimeException("Should not occur", e);
    }
}