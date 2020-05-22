HashMap<String, Object> env = new HashMap<>();
    env.put("jmx.remote.x.password.file", "/somepath/jmxremote.password");
    env.put("jmx.remote.x.access.file", "/somepath/jmxremote.access");

    JMXConnectorServer connectorServer =
        JMXConnectorServerFactory.newJMXConnectorServer(url, env, mbs);