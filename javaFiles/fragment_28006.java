public interface MethodInvoker {

    // the method + the instance from which the method should be called
    public void setMethod(Method method, Object instance);

    // invokes the method
    public void invoke(Object... params) throws Exception;

}