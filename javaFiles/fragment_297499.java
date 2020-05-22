protected static String tryToFindUserLogin() {

    try {
        /*** Obtain the classLoader from the calling Thread, instead of using the default ***/
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class classFacesContext = classLoader.loadClass("javax.faces.context.FacesContext");
        Class classExternalContext = classLoader.loadClass("javax.faces.context.ExternalContext");
        /**************/

        Method methodGetCurrentInstance =  classFacesContext.getMethod("getCurrentInstance", (Class[])null);
        Method methodGetExternalContext =  classFacesContext.getMethod("getExternalContext", (Class[])null);
        Method methodGetRemoteUser =  classExternalContext.getMethod("getRemoteUser", (Class[])null);

        Object currentFacesContext = methodGetCurrentInstance.invoke(null, (Object[])null);

        Object currentExternalContext = methodGetExternalContext.invoke(currentFacesContext, (Object[])null);
        String login = (String)  methodGetRemoteUser.invoke(currentExternalContext, (Object[])null);
        logger.debug("Found Weblogin: " + login);
        return login;

    } catch (Throwable e) {
        logger.debug(e, e);
    }

    return "anonymous";
    }