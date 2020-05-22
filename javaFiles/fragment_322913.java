public static void main(String[] args) throws Exception {
    final JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:<port>/jmxrmi");
    final JMXConnector jmxc = JMXConnectorFactory.connect(url);
    final MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
    final ObjectName name = new ObjectName("com.example.producer:type=SomeUnqiueName");
    final ProducerMBean mbeanProxy = JMX.newMBeanProxy(mbsc, name, ProducerMBean.class, true);
    mbeanProxy.add("TEST");
    mbeanProxy.add("EXIT");
}