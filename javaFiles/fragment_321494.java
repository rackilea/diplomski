class MyProxiedSavedInvocationHandler extends ProxiedSavedInvocationHandler {
        ...
        }

        ProxiedSavedInvocationHandler handler = new MyProxiedSavedInvocationHandler(target); 
        Object proxy = handler.createProxy();

        // DESIRED API THROUGH STATIC UTILIY
        Object proxied1 = ProxiedSavedInvocationHandler.getProxied(proxy);

        // DESIRED API THROUGH INSTANCE UTILIY
        Object proxied2 = handler.getProxied();