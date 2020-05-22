public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("closed")) {
            return closed();
        } else if (method.getName().equals("shutdown")) {
            _close();
            executor.shutdown();
        } else if (method.getName().equals("shutdownNow")) {
            _close();
            return executor.shutdownNow();
        } else {
            return method.invoke(executor, args);
        }

        return null;
    }