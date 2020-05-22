Map<String,String[]> env = new HashMap<String, String[]>();
env.put( JMXConnector.CREDENTIALS, new String[]{"user","pass"} );
JMXServiceURL address = new JMXServiceURL("service:rmi:///jndi/rmi://host:port/jmxrmi");
JMXConnector connector = JMXConnectorFactory.connect(address,env);
MBeanServerConnection mbs = connector.getMBeanServerConnection();

//get all mbeans
Set<ObjectInstance> beans = mbs.queryMBeans(null,null);

for( ObjectInstance instance : beans )
{
    MBeanInfo info = mbs.getMBeanInfo( instance.getObjectName() );
}