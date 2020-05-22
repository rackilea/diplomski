public void setUpActiveMQResources() throws IOException, NamingException {
    InitialContext context = createInitialContext("/activemq.jndi.properties");
    // do what you want
}

public InitialContext createInitialContext(String resource) throws IOException, NamingException {
    InputStream is = getClass().getResourceAsStream(resource);
    Properties props = new Properties();
    try {
        props.load(is);
    } finally {
        is.close();
    }
    return new InitialContext(props);
}