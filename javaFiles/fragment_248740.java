String host = "localhost";  // or some A.B.C.D
int port = 1234;
String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";
JMXServiceURL serviceUrl = new JMXServiceURL(url);
JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);
try {
   MBeanServerConnection mbeanConn = jmxConnector.getMBeanServerConnection();
   // now query to get the beans or whatever
   Set<ObjectName> beanSet = mbeanConn.queryNames(null, null);
   ...
} finally {
   jmxConnector.close();
}