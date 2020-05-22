@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("set")) {
            properties.put(method.getName().substring(3), args[0]);
            return null;
        } else if (method.getName().startsWith("get")) {
            return properties.get(method.getName().substring(3));
        } else if (method.getName().startsWith("is")) {
            return properties.get(method.getName().substring(2));
        } else if (method.getName().equals("equals")) {
            return proxy == args[0];
        } else if (method.getName().equals("hashCode")) {
            return System.identityHashCode(proxy);
        } else if (method.getName().equals("toString")) {
            return proxy.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(proxy))
                    + " with InvocationHandler " + this;
        } else {
            throw new IllegalStateException(String.valueOf(method));
        }
    }