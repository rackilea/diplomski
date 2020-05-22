Properties jndiProps = new Properties();
jndiProps.puy(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
jndiProps.put(Context.SECURITY_PRINCIPAL, JBOSS_USER);
jndiProps.put(Context.SECURITY_CREDENTIALS, JBOSS_PWD);
jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
jndiProps.put(Context.PROVIDER_URL, "remote://yourhost:yourport");
InitialContext initialContext = new InitialContext(jndiProps);
YourRemote remote=(YourRemote)initialContext.lookup("java:/app-name/ejb-jar-name/YourBean!package.YourRemote");