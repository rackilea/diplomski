abstract class InvocationHandlerWithTarget implements InvocationHandler {
    protected final Object target;

    public InvocationHandlerWithTarget(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }
}

class DefaultInvocationHandler extends  InvocationHandlerWithTarget {
    public DefaultInvocationHandler(Object target) {
        super(target);
    }

    @Override
    public Object invoke(final Object o, final Method method, final Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}