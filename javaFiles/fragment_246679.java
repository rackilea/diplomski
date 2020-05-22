@Override
    public void contextInitialized(ServletContextEvent sce) {
        // get JSF application factory
        ApplicationFactory applicationFactory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
        Application application = applicationFactory.getApplication();
        ActionListener defaultActionListener = application.getActionListener();

        // create proxy for the default actionlistener
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ActionListenerInvocationHandler actionListenerInvocationHandler = new ActionListenerInvocationHandler(defaultActionListener);
        @SuppressWarnings("rawtypes")
        Class[] interfaces = new Class[] { ActionListener.class };
        ActionListener actionListenerProxy = (ActionListener) Proxy.newProxyInstance(contextClassLoader, interfaces, actionListenerInvocationHandler);

        // set proxied actionListener as new default actionlistener
        application.setActionListener(actionListenerProxy);

    }