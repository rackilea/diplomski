JMXServiceURL serviceURL = new JMXServiceURL("t3", hostname, port, "/jndi/" + DomainRuntimeServiceMBean.MBEANSERVER_JNDI_NAME);
Hashtable h = new Hashtable();
h.put(Context.SECURITY_PRINCIPAL, username);
h.put(Context.SECURITY_CREDENTIALS, password);
h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, "weblogic.management.remote");
MBeanServerConnection bco = JMXConnectorFactory.connect(serviceURL, h).getMBeanServerConnection();

DomainRuntimeServiceMBean domainRuntimeServiceMBean = (DomainRuntimeServiceMBean) MBeanServerInvocationHandler.newProxyInstance(bco, new ObjectName(DomainRuntimeServiceMBean.OBJECT_NAME));        
DomainMBean dem = domainRuntimeServiceMBean.getDomainConfiguration();
JMSSystemResourceMBean[] jmsSRs = dem.getJMSSystemResources();

JMSServerMBean[] jmsSvrs = dem.getJMSServers();
for(JMSServerMBean jmsSvr : jmsSvrs){
  System.out.println("JMS Servername: "+jmsSvr.getName());
}

for(JMSSystemResourceMBean jmsSR : jmsSRs){
  System.err.println(jmsSR.getName());
  QueueBean[] qbeans = jmsSR.getJMSResource().getQueues();
    for(QueueBean qbean : qbeans){
      System.out.println("JNDI NAME: "+qbean.getJNDIName()+" queuename : "+qbean.getName());
    }
}