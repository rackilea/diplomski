// connection
String url = "service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi";
JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(url));
MBeanServerConnection connection = connector.getMBeanServerConnection();
// get queue size
ObjectName nameConsumers = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=myqueue");
DestinationViewMBean mbView = MBeanServerInvocationHandler.newProxyInstance(connection, nameConsumers, DestinationViewMBean.class, true);
long queueSize = mbView.getQueueSize();