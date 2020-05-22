final JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(connectorAddress));
final MBeanServerConnection mBeanServerConnection = connector.getMBeanServerConnection();
final ObjectName commandLine = new ObjectName("java.lang:type=Runtime");
final List<Attribute> arguments = mBeanServerConnection.getAttributes(commandLine, new String[] {"InputArguments"}).asList();
String[] inputArguments = (String[]) arguments.get(0).getValue();
System.out.println(Arrays.asList(inputArguments));
connector.close();