public class MethodInvokerImpl implements MethodInvoker {

    private Method method;
    private Object instance;

    @Override
    public void setMethod(Method method, Object instance) {
        this.method = method;
        this.instance = instance;
    }

    @Override
    public void invoke(Object... params) throws Exception {
        // first param: instance, then the parameters
        method.invoke(instance, params);
    }

}