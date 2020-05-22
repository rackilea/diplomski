public abstract class ProxiedSavedInvocationHandler implements InvocationHandler {
        public static Object getProxied(Object proxy) {
            if (!Proxy.isProxyClass(proxy.getClass())) 
                return null;

            InvocationHandler handler = Proxy.getInvocationHandler(proxy);
            return (handler instanceof ProxiedSavedInvocationHandler) ? 
                    ((ProxiedSavedInvocationHandler)handler).proxied : null;
        }

        protected final Object proxied;

        public ProxiedSavedInvocationHandler(Object proxied) { 
            this.proxied = proxied; 
        }

        public Object getProxied() {
            return proxied;
        }

        public Object createProxy() {
            Class<? extends Object> clazz = proxied.getClass();
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        }
    }