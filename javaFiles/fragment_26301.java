JMXConnector jmxc = getJMXConnector();  // Takes care of our connection
MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

ObjectName mbeanName = new ObjectName("com.xyz.prodname:type=LogManager");

// This change demonstrates what must be done
Object result = mbsc.getAttribute(mbeanName, "AttributeNameAsItAppearsInJConsole");