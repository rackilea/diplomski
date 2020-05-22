protected SelectInput proxySelectForLocator(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new SelectElementWrapperHandler(locator);

        SelectInput proxy;
        proxy = (SelectInput) Proxy.newProxyInstance(
            loader, new Class[]{SelectInput.class}, handler);
        return proxy;
    }