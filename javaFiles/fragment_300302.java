public class AnyInvocationHandler implements InvocationHandler {
    final IAnyThing iat;

    public AnyInvocationHandler(IAnyThing iat) {
        this.iat = iat;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // call the same method on a real object.
        return method.invoke(iat, args);
    }
}