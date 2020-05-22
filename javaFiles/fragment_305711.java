public static <T> T connectEJB(String jndi) throws NamingException {
    Properties clientProperties = new Properties();
    clientProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
    clientProperties.put("remote.connections", "default");
    clientProperties.put("remote.connection.default.port", myPort);
    clientProperties.put("remote.connection.default.host", myHost);
    clientProperties.put("remote.connection.default.username", myUser);
    clientProperties.put("remote.connection.default.password", myPassword);
    clientProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");

    EJBClientConfiguration ejbClientConfiguration = new PropertiesBasedEJBClientConfiguration(clientProperties);
    ContextSelector<EJBClientContext> contextSelector = new ConfigBasedEJBClientContextSelector(ejbClientConfiguration);
    EJBClientContext.setSelector(contextSelector);

    Properties properties = new Properties();
    properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    Context context = new InitialContext(properties);
    return (T) context.lookup(jndi);
}