Thread currentThread = Thread.currentThread();
    ClassLoader oldClassLoader = currentThread.getContextClassLoader();
    try {
        //switching the classloader to prevent class loading glassfish classloading issues
        currentThread.setContextClassLoader(getClass().getClassLoader());
        //method to run
        callEJBStateful(messageContext);
    } catch (Exception e) {
        handleException("Error calling EJB Service from EJBConnector", e, messageContext);
    } finally {
        if (oldClassLoader != null) {
            //resetting the classloader
            currentThread.setContextClassLoader(oldClassLoader);
        }
    }