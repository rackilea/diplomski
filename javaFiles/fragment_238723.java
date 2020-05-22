Class<?> handlerCl = Class.forName("sun.misc.SignalHandler");
        Class<?> signalCl = Class.forName("sun.misc.Signal");

        Constructor signalCtor = signalCl.getConstructor(String.class);
        Method signalHandle = signalCl.getMethod("handle", signalCl, handlerCl);

        // Create a proxy class that implements SignalHandler
        Class<?> proxyClass = Proxy.getProxyClass(signalCl.getClassLoader(),
            handlerCl);

        // This is used by the instance of proxyClass to dispatch method calls
        InvocationHandler invHandler = new InvocationHandler()
        {
            public Object invoke(Object proxy,
                Method method, Object[] args) throws Throwable
            {
                // proxy is the SignalHandler's "this" rederence
                // method will be the handle(Signal) method
                // args[0] will be an instance of Signal
                // If you're using this object for multiple signals, you'll
                // you'll need to use the "getName" method to determine which
                // signal you have caught.
                return null;
            }
        };

        // Get the constructor and create an instance of proxyClass
        Constructor<?> proxyCtor = proxyClass.getConstructor(InvocationHandler.class);
        Object handler = proxyCtor.newInstance(invHandler);

        // Create the signal and call Signal.handle to bind handler to signal
        Object signal = signalCtor.newInstance("TERM");
        signalHandle.invoke(null, signal, handler);