// Configure JNDI properties.
Properties jndiProps = new Properties();
jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
        "org.jnp.interfaces.NamingContextFactory");
jndiProps.put(Context.PROVIDER_URL, "remote://localhost:1099");
jndiProps.put(Context.URL_PKG_PREFIXES,
        "org.jboss.naming.org.jnp.interfaces");

Context context = new InitialContext();