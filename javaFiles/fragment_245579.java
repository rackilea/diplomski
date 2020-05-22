Properties p = new Properties();
    p.put(Context.INITIAL_CONTEXT_FACTORY,
            "org.jboss.naming.remote.client.InitialContextFactory");
    p.put(Context.URL_PKG_PREFIXES,
            "org.jboss.as.naming.interfaces:org.jboss.ejb.client.naming");
    p.put(Context.PROVIDER_URL, "remote://localhost:4447");
    p.put("jboss.naming.client.ejb.context", true);
    InitialContext ctx = new InitialContext(p);