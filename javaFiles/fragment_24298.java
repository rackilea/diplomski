public class Handler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("someMethod")) {
            System.out.println("this is the business logic of `someMethod`");
            System.out.println("argument: " + args[0]);
            return null;
        }
        return null;
    }
}