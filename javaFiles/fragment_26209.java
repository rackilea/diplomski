MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
RPCServer rpcServer =  new RPCServer();
ObjectName objectName = new ObjectName("org.foo.RPCServer.jmx:type=RPCServerInterface");

StandardMBean standardMBean = new StandardMBean(rpcServer,RPCServerInterface.class);
mBeanServer.registerMBean(standardMBean, objectName);