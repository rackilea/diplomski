static MBeanServerConnection connect(VirtualMachine vm) throws IOException
{
  String connectorAddress = vm.getAgentProperties().getProperty(CONNECTOR_ADDRESS);
  if(connectorAddress == null)
  {
    System.out.println("loading agent");
    Properties props = vm.getSystemProperties();
    String home  = props.getProperty("java.home");
    String agent = home+File.separator+"lib"+File.separator+"management-agent.jar";
    try {
      vm.loadAgent(agent);
    } catch (AgentLoadException|AgentInitializationException ex) {
      throw new IOException(ex);
    }
    connectorAddress = vm.getAgentProperties().getProperty(CONNECTOR_ADDRESS);
    while(connectorAddress==null) try {
      Thread.sleep(1000);
      connectorAddress = vm.getAgentProperties().getProperty(CONNECTOR_ADDRESS);
    } catch(InterruptedException ex){}
  }
  JMXConnector c=JMXConnectorFactory.connect(new JMXServiceURL(connectorAddress));
  return c.getMBeanServerConnection();
}