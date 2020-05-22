ClassLoader cl = Thread.currentThread().getContextClassLoader();
    URL authconf = null;
    authconf= cl.getResource("META-INF/jaas-win.config");

    if (authconf == null) {
        loginContext = null;
        return;
    }

    String p;
    try {
         p = URLDecoder.decode(authconf.toExternalForm(), "UTF-8");
         System.setProperty("java.security.auth.login.config", p);
    } catch (UnsupportedEncodingException e1) {
        loginContext = null;
        return;
    }