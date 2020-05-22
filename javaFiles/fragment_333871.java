private int getTomcatContainerPort() throws MalformedObjectNameException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, ReflectionException {
    int serverPort = 0;
    MBeanServer mBeanServer = MBeanServerFactory.findMBeanServer(null).get(0);
    ObjectName name = new ObjectName("Catalina", "type", "Server");
    Server server = (Server) mBeanServer.getAttribute(name, "managedResource");
    Service[] services = server.findServices();
    for (Service service : services) {
        for (Connector connector : service.findConnectors()) {
            ProtocolHandler protocolHandler = connector.getProtocolHandler();
            if (protocolHandler instanceof Http11Protocol
                || protocolHandler instanceof Http11AprProtocol
                || protocolHandler instanceof Http11NioProtocol) {
                serverPort = connector.getPort();
                break;
            }
        }
    }
    return serverPort;
}