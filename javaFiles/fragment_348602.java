Object proxied = Proxy.newProxyInstance(test.getClass().getClassLoader(), test.getClass().getInterfaces(),
            new DefaultInvocationHandler(test));

[...]

if (Proxy.isProxyClass(proxied.getClass())) {
    var handler = Proxy.getInvocationHandler(proxied);
    if (handler instanceof InvocationHandlerWithTarget) {
        var handlerWithTarget = (InvocationHandlerWithTarget) handler;

        // now process the target
        handlerWithTarget.getTarget();
    }
}