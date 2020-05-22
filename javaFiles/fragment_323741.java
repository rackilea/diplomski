JMXConnector connector;
jmxURL = service:jmx:rmi:///jndi/rmi://hostname:1099/karaf-root;
String[] userCredentialsArray = new String[2];
userCredentialsArray[0] = xxx;
userCredentialsArray[1] = xxx;
queueName=test;

connector = JMXConnectorFactory.connect(new JMXServiceURL(jmxURL),credentialsMap);
LOGGER.info("JMX connection established " + connector);
MBeanServerConnection connection = connector.getMBeanServerConnection();
LOGGER.info("MBeanServerConnection connection established "+ connection);
ObjectName nameConsumers = new ObjectName("org.apache.activemq:type=Broker,brokerName=amq,destinationType=Queue,destinationName="+ queueName);
LOGGER.info("ObjectName created " + nameConsumers);
DestinationViewMBean mbView = MBeanServerInvocationHandler.newProxyInstance(connection, nameConsumers,DestinationViewMBean.class, true);
System.out.println("count - "+mbView.getQueueSize() );