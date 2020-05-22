class FooInvocationHandler implements InvocationHandler {

    private Foo foo;

    FooInvocationHandler(Foo foo) {
        this.foo = foo;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if (method.getName().equals("bar"))
            System.out.println("foo me");
            // return null if you don't want to invoke the method below
        }
        return method.invoke(foo, args); // Calls the original method
    }
}