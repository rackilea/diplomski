private void configureForwardedRequestCustomizer()
    {
        JettyHTTPServerEngineFactory factory = new JettyHTTPServerEngineFactory();
        JettyHTTPServerEngine engine = factory.retrieveJettyHTTPServerEngine(port);
        Iterator<ConnectionFactory> iter = engine.getConnector().getConnectionFactories().iterator();
        while (iter.hasNext())
        {
            HttpConnectionFactory f = (HttpConnectionFactory) iter.next();
            f.getHttpConfiguration().addCustomizer(new ForwardedRequestCustomizer());
        }
    }